
package com.example.bankaccount

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.bankaccount.Navigation.SetupNavGraph
import com.example.bankaccount.RoomDatabase.MoneyDatabase
import com.example.bankaccount.presetation.MoneyViewModel
import com.example.bankaccount.screens.HomeScreen
import com.example.bankaccount.screens.IncomeScreen
import com.example.bankaccount.ui.theme.BankaccountTheme



class MainActivity : ComponentActivity() {
    private  val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            MoneyDatabase::class.java,
            name = "Money.db"
        ).build()
    }
    private  val viewModel by viewModels<MoneyViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun<T: ViewModel> create(modelClass: Class<T>): T{
                    return MoneyViewModel(database.dao) as T
                }
            }
        }
    )
    lateinit var navController:NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankaccountTheme {
                navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color(0xFFFFFFFF), Color(0xFF0F6262)),
                                startY = 0f,
                                endY = 2500f
                            )
                        )
                ) {
                    val state by viewModel.state.collectAsState()
                    val navController= rememberNavController()

                    NavHost(navController = navController, startDestination = "HomeScreen"){
                        composable(route = "HomeScreen"){
                            HomeScreen(
                                state =state,
                                navController =navController ,
                                onEvent =viewModel::onEvent )
                        }
                        composable(route = "IncomeScreen"){
                            IncomeScreen(
                                state=state,
                                navController=navController,
                                onEvent = viewModel::onEvent
                            )
                        }
                    }
                   // IncomePage()
                   //SetupNavGraph(navController = navController)
                }
            }
        }
    }
}

