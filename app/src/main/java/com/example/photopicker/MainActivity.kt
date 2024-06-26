package com.example.photopicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.photopicker.View.BottomBar
import com.example.photopicker.View.Home
import com.example.photopicker.View.MultiplePhotoPicker
import com.example.photopicker.View.SinglePhotoPicker
import com.example.photopicker.View.SingleVideoPicker
import com.example.photopicker.ui.theme.PhotoPickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoPickerTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "single") {
                    composable("home") {
                        Scaffold(
                            bottomBar = {
                                BottomBar(
                                    navController = navController
                                )
                            },
                        ) {
                            innerPadding ->
                            Text(
                                modifier = Modifier.padding(innerPadding),
                                text = "Cap nhat du lieu."
                            )

                            Home()
                        }
                    }
                    composable("single") {
                        Scaffold(
                            bottomBar = {
                                BottomBar(
                                    navController = navController
                                )
                            },
                        ) {  innerPadding ->
                            Text(
                                modifier = Modifier.padding(innerPadding),
                                text = "Cap nhat du lieu."
                            )
                            SinglePhotoPicker()
                        }
                    }
                    composable("multi") {
                        Scaffold(
                            bottomBar = {
                                BottomBar(navController = navController)
                            },
                        ){  innerPadding ->
                            Text(
                                modifier = Modifier.padding(innerPadding),
                                text = "Cap nhat du lieu."
                            )
                            MultiplePhotoPicker()
                        }
                    }

                    composable("video") {
                        Scaffold(
                            bottomBar = {
                                BottomBar(navController = navController)
                            },
                        ){  innerPadding ->
                            Text(
                                modifier = Modifier.padding(innerPadding),
                                text = "Cap nhat du lieu."
                            )
                            SingleVideoPicker()
                        }
                    }
                    /*...*/
                }
//                SinglePhotoPicker()
//                MultiplePhotoPicker()
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PhotoPickerTheme {
        Greeting("Android")
    }
}