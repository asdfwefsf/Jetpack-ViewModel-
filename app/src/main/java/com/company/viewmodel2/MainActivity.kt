package com.company.viewmodel2

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.company.viewmodel2.ui.theme.Viewmodel2Theme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Viewmodel2Theme {
                val changeBackgroundColorViewModel = viewModel<changeBackgroundColorViewModel>(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return changeBackgroundColorViewModel(
                                factoryText = "여기에서 Parameter 활용하면 된다."
                            ) as T
                        }
                    }
                )
                Column {
                    Surface(
                        color = changeBackgroundColorViewModel.backgroundColor.value
                    ) {
                        Column {
                            Button(onClick = {
                                changeBackgroundColorViewModel.changeBackgroundColor()
                            }) {
                                Text(
                                    text = "배경 색상 변경하기"
                                )
                            }
                        }
                    }
                    Spacer(Modifier.size(16.dp))
                    Surface(
                        color = Color.Green
                    ) {
                        Button(onClick = {}) {
                            Text(
                                text = changeBackgroundColorViewModel.factoryText
                            )
                        }
                    }
                    Spacer(Modifier.size(16.dp))
                    Surface(
                        color = Color.White
                    ) {
                        OutlinedTextField(
                            value = changeBackgroundColorViewModel.changedText.value,
                            onValueChange = { newText ->
                                changeBackgroundColorViewModel.changedText.value = newText
                            }
                        )
                    }
                    Spacer(Modifier.size(16.dp))
                    Text(
                        text = changeBackgroundColorViewModel.defaultText.value
                    )
                    Spacer(Modifier.size(16.dp))
                    Button(onClick = {
                        changeBackgroundColorViewModel.changeText()
                    }) {
                        Text(
                            "텍스트 변경"
                        )
                    }
                }


            }
        }
    }
}
