package com.example.cupcake.data

data class OrderUiState(
    val deviceType: String = "",
    val processor: String = "",
    val memory: String = "",
    val storage: String = "",
    val monitor: String = "",
    val graphicsCard: String = "",
    val totalPrice: String = "Rp0"
)