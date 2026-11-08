
package com.example.cupcake.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.selection.selectable
import androidx.compose.ui.unit.dp
import com.example.cupcake.data.ComputerOption
import java.text.NumberFormat
import java.util.Locale

@Composable
fun SelectOptionScreen(
    title: String,
    options: List<ComputerOption>,
    selectedOption: String,
    onSelectionChanged: (String) -> Unit,
    onNextButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = title)

        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onSelectionChanged(option.name)
                    }
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == option.name,
                    onClick = {
                        onSelectionChanged(option.name)
                    }
                )

                Text(text = option.name)

                Spacer(modifier = Modifier.weight(1f))

                val priceText = if (option.price == 0) {
                    "Tanpa biaya tambahan"
                } else {
                    NumberFormat.getCurrencyInstance(
                        Locale("id", "ID")
                    ).format(option.price)
                }

                Text(text = priceText)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onNextButtonClicked,
            enabled = selectedOption.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Lanjut")
        }
    }
}
