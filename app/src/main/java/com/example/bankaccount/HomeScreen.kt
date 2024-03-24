@file:JvmName("HomeScreenKt")

package com.example.bankaccount

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bankaccount.ViewModel.BankViewModel
import com.example.bankaccount.ViewModel.ExpensesVM
import com.example.bankaccount.presetation.MoneyEvent
import com.example.bankaccount.presetation.MoneyState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(
    expensesVM: ExpensesVM = viewModel(),
   // state: MoneyState,
    navController: NavController,
    //onEvent: (MoneyEvent)->Unit
){

    Scaffold(
        topBar = {


        }
    ) {

    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 18.dp)
        , horizontalAlignment = Alignment.CenterHorizontally) {
        ///////OutlinedTextField value//////////
        Row(modifier = Modifier
            .fillMaxWidth()){
            Button(onClick = {
                navController.popBackStack()
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Back" )
            }
        }
        Box(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF1F3333))
            .padding(horizontal = 100.dp, vertical = 10.dp)
        ){
            Text(text = "home", modifier = Modifier, Color.White)
        }
        Spacer(modifier = Modifier.padding(vertical = 144.dp))
        Column(modifier = Modifier.fillMaxWidth()
            ,horizontalAlignment = Alignment.CenterHorizontally
           ){
            //Saving Button verticalArrangement = Arrangement.Center
            Box(modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF1F3333))
                .padding(horizontal = 100.dp, vertical = 10.dp),

            ){

                Text(text = "Savings ${expensesVM.Saving()}", modifier = Modifier,
                    Color.White,
                    fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            //Income Button
            Box(modifier = Modifier
                .clickable { navController.navigate(route = "Income_screen") }
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF1F3333))
                .padding(horizontal = 100.dp, vertical = 10.dp)
            ){
                Text(text = "Income", modifier = Modifier,
                    Color.White,
                    fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.padding(vertical = 15.dp))
            //Expense Button
            Box(modifier = Modifier
                .clickable { navController.navigate(route = "Expense_screen") }
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF1F3333))
                .padding(horizontal = 100.dp, vertical = 10.dp)
            ){
                Text(text = "Expenses", modifier = Modifier,
                    Color.White,
                    fontSize = 20.sp)
            }
        }
    }

}



@Composable
@Preview(showBackground = true)
fun FixedPaymentsPreview(){
   homeScreen(navController = rememberNavController())
    /////////AlertDialogBox///////
//    if(isOpen) {
//        AlertDialog(onDismissRequest = { isOpen = false },
//            title = { Text(text = "Choose a color and specify your spending") },
//            text = {
//                Column(modifier = Modifier.fillMaxWidth()) {
//                    ////////spending text field
//                    OutlinedTextField(value = spending,
//                        onValueChange = {
//                            spending = it
//                        }
//                    )
//                    Spacer(modifier = Modifier.padding(8.dp))
//                    /////color selecter
//                    Row(modifier = Modifier.fillMaxWidth()) {
//                        Button(
//                            onClick = {  color = Color.Red },
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = Color.Red
//                            )
//                        ) {
//
//                        }
//                        Button(
//                            onClick = { color = Color.Red  },
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = Color.Yellow
//                            )
//                        ) {
//                            Log.d("redd", String())
//                        }
//                        Button(
//                            onClick = {  color = Color.Red },
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = Color.Blue
//                            )
//                        ) {
//
//                        }
//                    }
//                }
//            },
//            ///add button
//            confirmButton = {
//                Button(onClick = {
//                    if (spending.isNotEmpty()) {
//                        list.add(spending)
//                        spending=""
//                        isOpen = false
//                    }
//                }) {
//                    Text(text = "Add",color=color)
//                }
//            },
//            dismissButton = {}
//        )
//    }dismissButton
}