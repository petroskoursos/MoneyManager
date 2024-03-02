package com.example.bankaccount

import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BankViewModel:ViewModel() {
    var incomeHolder = mutableStateListOf<Int>()
    var expensesHolder= mutableStateListOf<Int>()

    fun addValue(isIncome:Boolean,value:String){
        viewModelScope.launch {
            if(value.isNotEmpty() && isIncome){
                incomeHolder.add(value.toInt())

            }else if(value.isNotEmpty() && !isIncome){
                expensesHolder.add(value.toInt())
            }
        }
    }

    fun removeLastValue(isIncome: Boolean){
        viewModelScope.launch {
            if(isIncome && incomeHolder.isNotEmpty()){
                incomeHolder.removeLast()
            }else if(!isIncome && expensesHolder.isNotEmpty()){
                expensesHolder.removeLast()
            }
        }
    }

    fun money():Int{
        return income()-expenses()
    }
    fun income():Int{
        var income=0
        for(item in incomeHolder){
            income+=item
        }
        return income
    }fun expenses():Int{
        var expenses=0
        for(item in expensesHolder){
            expenses+=item
        }
        return expenses
    }
}