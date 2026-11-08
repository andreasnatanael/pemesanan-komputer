package com.example.cupcake.data

data class ComputerOption(
    val name: String,
    val price: Int
)

object DataSource {

    val deviceTypes = listOf(
        ComputerOption("Desktop", 0),
        ComputerOption("Notebook", 0)
    )

    val processors = listOf(
        ComputerOption("Intel Core i3", 2500000),
        ComputerOption("Intel Core i5", 3500000),
        ComputerOption("Intel Core i7", 5500000),
        ComputerOption("AMD Ryzen 5", 3200000),
        ComputerOption("AMD Ryzen 7", 5000000)
    )

    val memories = listOf(
        ComputerOption("8 GB", 400000),
        ComputerOption("16 GB", 750000),
        ComputerOption("32 GB", 1400000)
    )

    val storages = listOf(
        ComputerOption("HDD 1 TB", 650000),
        ComputerOption("SSD 256 GB", 450000),
        ComputerOption("SSD 512 GB", 750000),
        ComputerOption("SSD 1 TB", 1300000)
    )

    val monitors = listOf(
        ComputerOption("14 inci", 0),
        ComputerOption("15,6 inci", 0),
        ComputerOption("21,5 inci", 1500000),
        ComputerOption("24 inci", 2200000)
    )

    val graphicsCards = listOf(
        ComputerOption("Integrated Graphics", 0),
        ComputerOption("NVIDIA GTX 1650", 2500000),
        ComputerOption("NVIDIA RTX 3050", 4500000),
        ComputerOption("NVIDIA RTX 4060", 6500000),
        ComputerOption("AMD Radeon", 1800000)
    )
}