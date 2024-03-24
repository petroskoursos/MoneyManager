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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bankaccount.Navigation.Screen
import com.example.bankaccount.ViewModel.IncomePageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IncomePage(
    incomePageViewModel: IncomePageViewModel = viewModel(),
    navController: NavController
){
    var dateList = remember{ mutableListOf<String>()}
    var amountList = remember{ mutableListOf<String>()}
    var date by remember{ mutableStateOf("")}
    var amount by remember{ mutableStateOf("")}
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 41.dp)
        , horizontalAlignment = Alignment.CenterHorizontally) {
        //Back Button
        Button(onClick = { navController.navigate(Screen.Home.route) }) {
            Icon(imageVector =Icons.Default.ArrowBack , contentDescription ="Back button" )
        }
        ///Header income box
        Box(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF1F3333))
            .padding(horizontal = 100.dp, vertical = 10.dp)
        ){
            Text(text = "Income", modifier = Modifier,Color.White)
        }
        //Outlined text field
        Row(modifier = Modifier
            .padding(start = 20.dp, end = 20.dp)){
            OutlinedTextField(value =date
                , modifier = Modifier.weight(2f)
                , onValueChange ={date=it}
                , label = { Text(text = "Enter Date")}
                , singleLine = true
                , keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            OutlinedTextField(value =amount
                , modifier = Modifier.weight(1f)
                , onValueChange ={amount=it}
                , label = { Text(text = "Enter Amount")}
                , singleLine = true
                , keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
        }
        // Add button
        Button(onClick = {
            if(amount.isNotEmpty() && date.isNotEmpty()){
                incomePageViewModel.AddDateAmount(date,amount)
                amount=""
                date=""
            }

        }) {
            Text(text = "Add ")
        }
        Spacer(modifier = Modifier.padding(top = 110.dp))
        //Displays the date and the amount that have been entered
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF203333)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LazyColumn {
                itemsIndexed(incomePageViewModel.datelist) { index, date ->
                    Row(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Date: $date", modifier = Modifier
                                .padding(start = 20.dp)
                                .weight(2f), color = Color.White

                        )
                        Text(
                            text = "Amount: ${incomePageViewModel.amountlist[index]}",
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .weight(1f),
                            color = Color.White,
                        )
                    }
                }


            }
        }

        }
    }








@Composable
@Preview(showBackground = true)
fun IncomePagePreview(){
    IncomePage(navController = rememberNavController())
}