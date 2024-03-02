package com.example.bankaccount

sealed class Screen(val route:String){
    object Home:Screen(route = "Home_screen")
    object Second:Screen(route = "Second_screen")
}
