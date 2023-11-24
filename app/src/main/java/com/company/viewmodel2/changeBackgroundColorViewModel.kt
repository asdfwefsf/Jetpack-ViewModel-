package com.company.viewmodel2

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import org.w3c.dom.Text

class changeBackgroundColorViewModel(
    val factoryText : String
) : ViewModel() {

    // 색상 변경
    private var innerBackGroundColor = mutableStateOf(Color.Green)
    fun changeBackgroundColor() {
        innerBackGroundColor.value = Color.Magenta
    }
    var backgroundColor : State<Color> = innerBackGroundColor

    // 텍스트 변경
    private var text = mutableStateOf("기본값")
    fun changeText() {
        defaultText.value = changedText.value
    }
    var changedText : MutableState<String> = text
    var defaultText : MutableState<String> = mutableStateOf("기본값")


}