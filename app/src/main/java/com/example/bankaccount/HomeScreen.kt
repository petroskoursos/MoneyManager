package com.example.bankaccount

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
@Preview(showBackground = true)
fun BankPreview(){
    Bank(BankViewModel(), navController = rememberNavController())
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bank(
    bankViewModel: BankViewModel= viewModel(),
    navController: NavController
) {

    var value by remember{ mutableStateOf("") }
    var isPressed by remember{ mutableStateOf(false) }
    val txtColorT= Color.White
    val txtColorF= MaterialTheme.colorScheme.background
    val backgroundColor= Color(32,51,51)
    val columnshape= RoundedCornerShape(8.dp)
    Column(modifier = Modifier
        .padding(18.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.End){
            Button(onClick = {
                navController.navigate(route = Screen.Second.route)
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                ),

            ) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription ="Next" )
            }
        }
        ////////////////////TextField////////////////////
        OutlinedTextField(
            value =value,
            onValueChange ={
                value=it
            },
            label = { Text(text = if(isPressed)"Income" else "expenses") },
            singleLine = true,
            keyboardOptions =  KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    bankViewModel.addValue(isPressed,value)
                    value=""
                }
            )

        )
        //Button Row
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            ////////////////////Add button//////////////////////
            Button(onClick = {
                bankViewModel.addValue(isPressed,value)
                value=""
            }) {
                Text(text = "add")
            }
            //////////////////Income/Expenses Button////////////////////
            Button(onClick = {
                isPressed= !isPressed
            }
            ) {
                Text(text = if(isPressed)"Income" else "expenses")
            }
            ////////////////////Remove Button//////////////////////
            Button(onClick = {
                bankViewModel.removeLastValue(isPressed)
            }) {
                Text(text = "delete")
            }
        }
        Spacer(modifier = Modifier.padding(top = 18.dp))
        //////////////////////Current money////////////////////
        Box(modifier = Modifier
            .background(backgroundColor, columnshape)
            .padding(18.dp)){
            Text(text = "Current Money: ${bankViewModel.money().toString()}")
        }
        ////////////////////Column for the Income/Expenses///////////////
        Column {
            Row(modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
                /*horizontalArrangement = Arrangement.SpaceBetween*/){
                ////////////////////Income///////////////
                Column(modifier = Modifier
                    .padding(18.dp)
                    .background(backgroundColor, columnshape)
                    .padding(8.dp)
                    .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Income",
                        color = if(isPressed) txtColorT else txtColorF
                    )
                    ///lazy column view list
                    LazyColumn() {
                        items(bankViewModel.incomeHolder) { amount ->
                            Text(text = amount.toString())
                        }
                    }
                    Text(text = "Income:${bankViewModel.income().toString()}",
                        color = Color.Yellow
                    )
                }
                /////////////////Expenses////////////////
                Column(modifier = Modifier
                    .padding(18.dp)
                    .weight(1f)
                    .background(backgroundColor, columnshape)
                    .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Expenses",
                        color = if(!isPressed) txtColorT else txtColorF,

                        )
                    ///lazy column view list
                    LazyColumn() {
                        items(bankViewModel.expensesHolder) { amount ->
                            Text(text = amount.toString())
                        }
                    }
                    Text(text = "Expenses:${bankViewModel.expenses().toString()}",
                        color = Color.Yellow)
                }

            }

        }

    }


}

