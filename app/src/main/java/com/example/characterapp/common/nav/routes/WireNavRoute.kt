package com.example.characterapp.common.nav.routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.gson.Gson

sealed class WireNavRoute (
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : WireNavRoute(
        route = "$ROUTE_WIRE_DETAILS/{$ARG_WIRE_INFO}",
        arguments = listOf(
            navArgument(ARG_WIRE_INFO) {
                type = NavType.StringType
            }
        )
    ) {
        fun routeForWire(input: WireInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_WIRE_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): WireInput {
            val json = entry.arguments?.getString(ARG_WIRE_INFO) ?: ""
            return WireInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_WIRE_DETAILS = "wireDetails"
        const val ARG_WIRE_INFO = "wireInfo"
    }
}

data class WireInput(
    val firstURL: String?,
    val icon: String?,
    val text: String?
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String): WireInput {
            return Gson().fromJson(json, WireInput::class.java)
        }
    }
}