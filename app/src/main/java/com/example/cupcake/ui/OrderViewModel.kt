package com.example.cupcake.ui

import androidx.lifecycle.ViewModel
import com.example.cupcake.data.DataSource
import com.example.cupcake.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.util.Locale

class OrderViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    fun setDeviceType(value: String) {
        updateState(deviceType = value)
    }

    fun setProcessor(value: String) {
        updateState(processor = value)
    }

    fun setMemory(value: String) {
        updateState(memory = value)
    }

    fun setStorage(value: String) {
        updateState(storage = value)
    }

    fun setMonitor(value: String) {
        updateState(monitor = value)
    }

    fun setGraphicsCard(value: String) {
        updateState(graphicsCard = value)
    }

    private fun updateState(
        deviceType: String = _uiState.value.deviceType,
        processor: String = _uiState.value.processor,
        memory: String = _uiState.value.memory,
        storage: String = _uiState.value.storage,
        monitor: String = _uiState.value.monitor,
        graphicsCard: String = _uiState.value.graphicsCard
    ) {
        val state = _uiState.value.copy(
            deviceType = deviceType,
            processor = processor,
            memory = memory,
            storage = storage,
            monitor = monitor,
            graphicsCard = graphicsCard
        )

        val total = calculateTotal(state)

        _uiState.update {
            state.copy(
                totalPrice = NumberFormat
                    .getCurrencyInstance(Locale("id", "ID"))
                    .format(total)
            )
        }
    }

    private fun calculateTotal(state: OrderUiState): Int {
        val devicePrice = when (state.deviceType) {
            "Desktop" -> 1500000
            "Notebook" -> 2500000
            else -> 0
        }

        fun findPrice(options: List<com.example.cupcake.data.ComputerOption>, name: String): Int {
            return options.find { it.name == name }?.price ?: 0
        }

        var total = devicePrice

        total += findPrice(DataSource.processors, state.processor)
        total += findPrice(DataSource.memories, state.memory)
        total += findPrice(DataSource.storages, state.storage)
        total += findPrice(DataSource.monitors, state.monitor)
        total += findPrice(DataSource.graphicsCards, state.graphicsCard)

        return total
    }

    fun resetOrder() {
        _uiState.value = OrderUiState()
    }
}