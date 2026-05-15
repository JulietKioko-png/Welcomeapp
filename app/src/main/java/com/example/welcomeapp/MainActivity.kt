package com.example.welcomeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var name by remember { mutableStateOf("") }
            var greeting by remember { mutableStateOf("Hello Juliet!") }
            var count by remember { mutableStateOf(0) }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = greeting, fontSize = 28.sp)
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Button clicked: $count times",
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Enter your name") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    count++
                    greeting = if (name.isNotEmpty()) {
                        "Hello $name!"
                    } else {
                        "Hello Juliet!"
                    }
                }) {
                    Text("Greet Me!")
                }
            }
        }
    }
}
