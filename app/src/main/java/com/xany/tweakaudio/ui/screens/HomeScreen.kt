package com.xany.tweakaudio.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.xany.tweakaudio.ui.components.ButtonSet
import com.xany.tweakaudio.ui.components.EditTextSoundLevel
import com.xany.tweakaudio.ui.viewmodel.HomeScreenViewModel


@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel = hiltViewModel()) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EditTextSoundLevel { updateText ->
            if (updateText.isNotEmpty()) {
                homeScreenViewModel.getDesiredVolume(updateText.toInt())
            }
        }
        ButtonSet(action = { homeScreenViewModel.adjustVolume(context) })
    }
}