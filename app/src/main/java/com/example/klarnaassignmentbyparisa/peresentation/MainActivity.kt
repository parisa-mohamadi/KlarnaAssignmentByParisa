package com.example.klarnaassignmentbyparisa.peresentation

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.klarnaassignmentbyparisa.peresentation.theme.DarkBlue
import com.example.klarnaassignmentbyparisa.peresentation.theme.DeepBlue
import com.example.klarnaassignmentbyparisa.peresentation.theme.KlarnaAssignmentByParisaTheme
import com.example.klarnaassignmentbyparisa.peresentation.theme.Pink40
import com.example.klarnaassignmentbyparisa.peresentation.theme.PurpleGrey40
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.loadWeatherInfo()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ))
        setContent {
            KlarnaAssignmentByParisaTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(PurpleGrey40)
                    ) {
                        WeatherCard(
                            state = viewModel.state,
                            backgroundColor = Pink40
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherForecast(state = viewModel.state)
                    }
                    if(viewModel.state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    viewModel.state.error?.let { error ->
                        Text(
                            text = error,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}