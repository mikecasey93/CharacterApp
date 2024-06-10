package com.example.characterapp.common.nav.routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.gson.Gson

sealed class SimpsonsNavRoute(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : SimpsonsNavRoute(
        route = "$ROUTE_SIMPSON_DETAILS/{$ARG_SIMPSON_INFO}",
        arguments = listOf(
            navArgument(ARG_SIMPSON_INFO) {
                type = NavType.StringType
            }
        )
    ) {
        fun routeForSimpspn(input: SimpsonInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_SIMPSON_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): SimpsonInput {
            val json = entry.arguments?.getString(ARG_SIMPSON_INFO) ?: ""
            return SimpsonInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_SIMPSON_DETAILS = "simpsonDetails"
        const val ARG_SIMPSON_INFO = "simpsonInfo"
    }
}

data class SimpsonInput(
    val firstURL: String?,
    val icon: String?,
    val text: String?
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }

    companion object {
        fun fromJson(json: String): SimpsonInput {
            return Gson().fromJson(json, SimpsonInput::class.java)
        }
    }
}