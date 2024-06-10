package com.example.characterapp.common.nav

import androidx.navigation.NamedNavArgument
import com.example.characterapp.common.nav.routes.SimpsonsNavRoute
import com.example.characterapp.common.nav.routes.WireNavRoute

sealed class NavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Home : NavRoutes(ROUTE_HOME)

    object Simpson : NavRoutes(SimpsonsNavRoute.Details.route, SimpsonsNavRoute.Details.arguments)

    object Wire : NavRoutes(WireNavRoute.Details.route, WireNavRoute.Details.arguments)


    companion object {
        const val ROUTE_HOME = "home"
        const val ROUTE_SEARCH = "search"
        const val ROUTE_SIMPSONS = "simpsons"
        const val ROUTE_WIRE = "wire"
    }

}