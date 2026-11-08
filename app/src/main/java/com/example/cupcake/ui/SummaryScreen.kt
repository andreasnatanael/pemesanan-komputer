package com.example.cupcake.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cupcake.data.OrderUiState

@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Ringkasan Pesanan",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Text("Jenis Komputer: ${orderUiState.deviceType}")
        Text("Processor: ${orderUiState.processor}")
        Text("RAM: ${orderUiState.memory}")
        Text("Storage: ${orderUiState.storage}")
        Text("Monitor: ${orderUiState.monitor}")
        Text("Graphics Card: ${orderUiState.graphicsCard}")

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Total Harga: ${orderUiState.totalPrice}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}