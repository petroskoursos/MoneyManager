package com.example.bankaccount.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.room.Entity
import androidx.room.PrimaryKey



class IncomePageViewModel:ViewModel() {
    var datelist =  mutableStateListOf<String>()
    var amountlist =  mutableStateListOf<String>()
    var value=0




    fun AddDateAmount(Date:String,Amount:String){
        datelist.add(Date)
        amountlist.add(Amount)
    }
    fun income():Int{
        var temp=0
        for(item in amountlist){
            temp+=item.toInt()
        }
        value=+temp
        return value
    }


}

