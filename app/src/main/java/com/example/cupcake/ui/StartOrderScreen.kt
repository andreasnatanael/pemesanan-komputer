
package com.example.cupcake.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cupcake.data.ComputerOption

@Composable
fun StartOrderScreen(
    options: List<ComputerOption>,
    onNextButtonClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedOption by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Pilih Jenis Komputer",
            style = MaterialTheme.typography.headlineSmall
        )

        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        selectedOption = option.name
                    }
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == option.name,
                    onClick = {
                        selectedOption = option.name
                    }
                )

                Text(
                    text = option.name,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                onNextButtonClicked(selectedOption)
            },
            enabled = selectedOption.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Lanjut")
        }
    }
}
