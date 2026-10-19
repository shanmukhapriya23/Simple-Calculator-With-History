package com.example.simplecalculatorwithhistory

data class HistoryItem(
    val expression: String,
    val result: String,
    val date: String
)