package com.snowplowanalytics.snowplowdemocompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.snowplowanalytics.snowplowdemocompose.data.Tracking
import com.snowplowanalytics.snowplowdemocompose.ui.SchemaDetailScreen
import com.snowplowanalytics.snowplowdemocompose.ui.SchemaDetailViewModel
import com.snowplowanalytics.snowplowdemocompose.ui.SchemaListScreen
import com.snowplowanalytics.snowplowdemocompose.ui.SchemaListViewModel

object Destinations {
    const val SCHEMA_LIST_ROUTE = "list"
    const val SCHEMA_DETAIL_ROUTE = "detail/{id}"
}

// This demo app displays the publicly available schemas from Iglu Central
// http://iglucentral.com/
@Composable
fun ComposeDemoApp(
        listViewModel: SchemaListViewModel,
        detailViewModel: SchemaDetailViewModel
) {
    val navController = rememberNavController()
    val uri = "https://datago.ru"

    // Initialises the Snowplow tracker and sets up screen view autotracking
    // A ScreenView event will be generated every time the navigation destination changes
    Tracking.setup("compose_demo")
    Tracking.AutoTrackScreenView(navController = navController)

    NavHost(
            navController = navController,
            startDestination = Destinations.SCHEMA_LIST_ROUTE
    ) {
        composable(Destinations.SCHEMA_LIST_ROUTE) {
            SchemaListScreen(
                    vm = listViewModel,
                    onSchemaClicked = {
                        navController.navigate("detail/${it.id}")
                    }
            )
        }

        composable(
                Destinations.SCHEMA_DETAIL_ROUTE,
                arguments = listOf(navArgument("id") { type = NavType.IntType }),
                deepLinks = listOf(navDeepLink { uriPattern = "$uri/{id}" })
        ) {
            val caseId: Int
            val caseId_ = if (it.arguments?.getInt("id") != null) it.arguments?.getInt("id") else 0
            caseId = caseId_!!
            val caseName = it.arguments?.getString("case")
            val caseDescription = it.arguments?.getString("description")
            SchemaDetailScreen(
                    vm = detailViewModel,
                    caseId = caseId,
                    onBackButtonClicked = { navController.navigate(Destinations.SCHEMA_LIST_ROUTE) }
            )
        }
    }
}
