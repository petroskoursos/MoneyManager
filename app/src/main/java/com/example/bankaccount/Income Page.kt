package com.example.bankaccount

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IncomePage(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 41.dp)
        , horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF1F3333))
            .padding(horizontal = 100.dp, vertical = 10.dp)
        ){
            Text(text = "Income", modifier = Modifier,Color.White)
        }
        Spacer(modifier = Modifier.padding(top = 110.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp) // Padding for entire Row
            .clip(RoundedCornerShape(20.dp)) // Rounded corners for the Row
            .background(Color(0xFF203333)), // Background color for the Row
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Space between items in Row
        ){
            Text(text = "Date 13/02:", modifier = Modifier
                .padding(start = 16.dp)
                ,color = Color.White)
            Text(text = "40$", modifier = Modifier
                .weight(3f)
                ,color = Color.White)
            }



    }
}



@Composable
@Preview(showBackground = true)
fun IncomePagePreview(){
    IncomePage()
}