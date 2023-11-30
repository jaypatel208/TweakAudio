package com.xany.tweakaudio.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    private var desiredVolume: Int? = null

    fun getDesiredVolume(volume: Int) {
        viewModelScope.launch {
            if (volume in 0..100) {
                desiredVolume = volume
            }
        }
    }

    fun adjustVolume(context: Context) {
        if (desiredVolume != null) {
            Toast.makeText(context, "Current volume is $desiredVolume", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Please enter volume to set", Toast.LENGTH_SHORT).show()
        }
    }
}