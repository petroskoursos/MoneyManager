package com.example.bankaccount

import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FixedPayments(navController: NavController){
    var value by remember{mutableStateOf("") }
    var list = remember { mutableStateListOf<String>() }
    var spending by remember { mutableStateOf("") }
    var isOpen by remember{ mutableStateOf(false) }
    var color=Color.Black

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
        OutlinedTextField(value = value,
            onValueChange = { value=it},
            label = {
                Text(text = "Enter Amount")
            },
            singleLine = true,
            trailingIcon = {
                Button(
                    onClick = {
                        isOpen = true
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    )
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add ")

                }
            })
                /////////AlertDialogBox///////
                if(isOpen) {
                    AlertDialog(onDismissRequest = { isOpen = false },
                        title = { Text(text = "Choose a color and specify your spending") },
                        text = {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                ////////spending text field
                                OutlinedTextField(value = spending,
                                    onValueChange = {
                                        spending = it
                                    }
                                )
                                Spacer(modifier = Modifier.padding(8.dp))
                                /////color selecter
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Button(
                                        onClick = {  color = Color.Red },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.Red
                                        )
                                    ) {

                                    }
                                    Button(
                                        onClick = { color = Color.Red  },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.Yellow
                                        )
                                    ) {
                                        Log.d("redd", String())
                                    }
                                    Button(
                                        onClick = {  color = Color.Red },
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.Blue
                                        )
                                    ) {

                                    }
                                }
                            }
                        },
                        ///add button
                        confirmButton = {
                            Button(onClick = {
                                if (spending.isNotEmpty()) {
                                    list.add(spending)
                                    spending=""
                                    isOpen = false
                                }
                            }) {
                                Text(text = "Add",color=color)
                            }
                        },
                        dismissButton = {}
                    )
                }
                LazyColumn(){
                    items(list){
                        Text(text = it, color = color)
                    }

                }
            }

    }



@Composable
@Preview(showBackground = true)
fun FixedPaymentsPreview(){
    FixedPayments(navController = rememberNavController())
}