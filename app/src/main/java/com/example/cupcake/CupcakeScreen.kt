
package com.example.cupcake

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.data.DataSource
import com.example.cupcake.ui.OrderViewModel
import com.example.cupcake.ui.SelectOptionScreen
import com.example.cupcake.ui.OrderSummaryScreen

enum class ComputerScreen {
    Start,
    Processor,
    Memory,
    Storage,
    Monitor,
    Graphics,
    Summary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState by viewModel.uiState.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = ComputerScreen.valueOf(
        backStackEntry?.destination?.route
            ?: ComputerScreen.Start.name
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pemesanan Komputer - ${currentScreen.name}")
                },
                navigationIcon = {
                    if (navController.previousBackStackEntry != null) {
                        IconButton(
                            onClick = {
                                navController.navigateUp()
                            }
                        ) {
                            Text("←")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ComputerScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(ComputerScreen.Start.name) {
                SelectOptionScreen(
                    title = "Pilih Jenis Komputer",
                    options = DataSource.deviceTypes,
                    selectedOption = uiState.deviceType,
                    onSelectionChanged = {
                        viewModel.setDeviceType(it)
                    },
                    onNextButtonClicked = {
                        navController.navigate(ComputerScreen.Processor.name)
                    }
                )
            }

            composable(ComputerScreen.Processor.name) {
                SelectOptionScreen(
                    title = "Pilih Processor",
                    options = DataSource.processors,
                    selectedOption = uiState.processor,
                    onSelectionChanged = {
                        viewModel.setProcessor(it)
                    },
                    onNextButtonClicked = {
                        navController.navigate(ComputerScreen.Memory.name)
                    }
                )
            }

            composable(ComputerScreen.Memory.name) {
                SelectOptionScreen(
                    title = "Pilih RAM",
                    options = DataSource.memories,
                    selectedOption = uiState.memory,
                    onSelectionChanged = {
                        viewModel.setMemory(it)
                    },
                    onNextButtonClicked = {
                        navController.navigate(ComputerScreen.Storage.name)
                    }
                )
            }

            composable(ComputerScreen.Storage.name) {
                SelectOptionScreen(
                    title = "Pilih Storage",
                    options = DataSource.storages,
                    selectedOption = uiState.storage,
                    onSelectionChanged = {
                        viewModel.setStorage(it)
                    },
                    onNextButtonClicked = {
                        navController.navigate(ComputerScreen.Monitor.name)
                    }
                )
            }

            composable(ComputerScreen.Monitor.name) {
                SelectOptionScreen(
                    title = "Pilih Monitor",
                    options = DataSource.monitors,
                    selectedOption = uiState.monitor,
                    onSelectionChanged = {
                        viewModel.setMonitor(it)
                    },
                    onNextButtonClicked = {
                        navController.navigate(ComputerScreen.Graphics.name)
                    }
                )
            }

            composable(ComputerScreen.Graphics.name) {
                SelectOptionScreen(
                    title = "Pilih Graphics Card",
                    options = DataSource.graphicsCards,
                    selectedOption = uiState.graphicsCard,
                    onSelectionChanged = {
                        viewModel.setGraphicsCard(it)
                    },
                    onNextButtonClicked = {
                        navController.navigate(ComputerScreen.Summary.name)
                    }
                )
            }

            composable(ComputerScreen.Summary.name) {
                OrderSummaryScreen(
                    orderUiState = uiState
                )
            }
        }
    }
}
