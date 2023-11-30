package com.xany.tweakaudio.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Audiotrack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun EditTextSoundLevel(onTextChange: (String) -> Unit) {
    var text by remember {
        mutableStateOf("")
    }
    val maxChar = 3

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxChar) {
                    text = it
                    onTextChange(it)
                }
            },
            textStyle = TextStyle(color = MaterialTheme.colorScheme.primary),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
            ),
            placeholder = {
                Text("Adjust the sound volume (0-100%)", color = MaterialTheme.colorScheme.secondary)
            },
            leadingIcon = { Image(imageVector = Icons.Outlined.Audiotrack, contentDescription = null) },
            singleLine = true
        )
    }
}

@Composable
fun ButtonSet(action: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = action) {
            Icon(imageVector = Icons.Outlined.Check, contentDescription = null, modifier = Modifier.padding(end = 8.dp))
            Text(text = "Set")
        }
    }
}