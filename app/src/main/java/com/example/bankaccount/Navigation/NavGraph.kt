package com.example.bankaccount.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bankaccount.Expenses
import com.example.bankaccount.IncomePage
import com.example.bankaccount.homeScreen

@Composable
fun SetupNavGraph(
    navController:NavHostController
){
    NavHost(
        navController =navController,
        startDestination = Screen.Home.route
    ){
        composable(route= Screen.Home.route)
        {
           homeScreen(navController = navController)
        }
        composable(route= Screen.Income.route)
        {
            IncomePage(navController=navController)
        }
        composable(route= Screen.Expense.route)
        {
            Expenses(navController=navController)
        }
//        composable(route=Screen.Expense.route)
//        {
//            (navController=navController)
//        }
    }
}