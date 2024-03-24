package com.example.bankaccount.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class BankViewModel:ViewModel() {
    var incomeHolder = mutableStateListOf<Int>()
    var expensesHolder= mutableStateListOf<Int>()

    fun addValue(isIncome:Boolean,value:String){

            if(value.isNotEmpty() && isIncome){
                incomeHolder.add(value.toInt())

            }else if(value.isNotEmpty() && !isIncome){
                expensesHolder.add(value.toInt())
            }

    }

    fun removeLastValue(isIncome: Boolean){
            if(isIncome && incomeHolder.isNotEmpty()){
                incomeHolder.removeLast()
            }else if(!isIncome && expensesHolder.isNotEmpty()){
                expensesHolder.removeLast()
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