package com.example.td_personal

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.td_personal.CalendarScreen.Presentation.CalendarScreen
import com.example.td_personal.DocumentScreen.Presentation.DocumentsScreen
import com.example.td_personal.HomeScreen.Presentation.HomeScreen
import kotlinx.serialization.Serializable

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Home::class.simpleName!!) {
        composable(Home::class.simpleName!!) {
            HomeScreen()
        }
        composable(Documents::class.simpleName!!) {
            DocumentsScreen()
        }
        composable(Account::class.simpleName!!) {
            AccountScreen()
        }
        composable(Calendar::class.simpleName!!) {
            CalendarScreen()
        }
    }
}

@Serializable
object Home

@Serializable
object Documents

@Serializable
object Account

@Serializable
object Calendar