package com.example.bankaccount.Navigation


sealed class Screen(val route:String){
    object Home: Screen(route = "Home_screen")

    object Income: Screen(route = "Income_screen")
    object Expense: Screen(route = "Expense_screen")
}
