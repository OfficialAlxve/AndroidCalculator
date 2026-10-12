package com.example.myandroidapp

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Size
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myandroidapp.ui.theme.MyAndroidAppTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAndroidAppTheme {
                    CalculatorApp()
                }
            }
        }
    }


@Composable
fun CalculatorApp(modifier: Modifier = Modifier){
    var name by remember { mutableStateOf("") }
    var input1 by remember { mutableStateOf("") }
    var input2 by remember { mutableStateOf("") }

    var result by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize().systemBarsPadding(),
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp)

    ){
        Text("Calculator", fontSize = 50.sp,style= MaterialTheme.typography.titleMedium, color = Color.Black,modifier=modifier.offset(0.dp,100.dp))
        Text("By Sowjeet Singha", fontSize = 15.sp,fontWeight = FontWeight.Bold,style= MaterialTheme.typography.bodySmall, color = Color.Red,modifier=modifier.offset(1.dp,95.dp))
    }
    Row(
        modifier=modifier.padding(top = 460.dp).padding(25.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp) // Puts 16dp of space between them
    ) {
        Button(onClick={
            val num1 = input1.toDoubleOrNull() ?: 0.0
            val num2 = input2.toDoubleOrNull() ?: 0.0
            result=(num1+num2).toString()
        },modifier=modifier.weight(1f)) {Text("+", fontSize = 40.sp) }

        Button(onClick={
            val num1 = input1.toDoubleOrNull() ?: 0.0
            val num2 = input2.toDoubleOrNull() ?: 0.0
            result=(num1-num2).toString()
        },modifier=modifier.weight(1f)) {Text("-",fontSize = 40.sp) }

        Button(onClick={
            val num1 = input1.toDoubleOrNull() ?: 0.0
            val num2 = input2.toDoubleOrNull() ?: 0.0
            result=(num1/num2).toString()
        },modifier=modifier.weight(1f)) {Text("/",fontSize = 40.sp) }

    }
    Row(
        modifier=modifier.padding(top = 510.dp).padding(25.dp).offset(0.dp,30.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp) // Puts 16dp of space between them
    ) {
        Button(onClick={
            val num1 = input1.toDoubleOrNull() ?: 0.0
            val num2 = input2.toDoubleOrNull() ?: 0.0
            result=(num1*num2).toString()

        },modifier=modifier.weight(1f)) {Text("*",fontSize = 40.sp) }


    }

    OutlinedTextField(value=input1 , onValueChange = {temp -> input1=temp}, label = {Text("Number#1",fontSize = 20.sp,color=Color.Black)},textStyle = LocalTextStyle.current.copy(fontSize = 30.sp,color=Color.DarkGray),modifier=modifier.padding(25.dp).offset(0.dp,250.dp).width(350.dp).height(80.dp))
    OutlinedTextField(value=input2 , onValueChange = {temp -> input2=temp}, label = {Text("Number#2", fontSize = 20.sp,color=Color.Black)},textStyle = LocalTextStyle.current.copy(fontSize = 30.sp,color=Color.DarkGray),modifier=modifier.padding(25.dp).offset(0.dp,350.dp).width(350.dp).height(80.dp))

    OutlinedTextField(value=result , onValueChange = {temp -> input2=temp},readOnly = true, enabled = false ,textStyle = LocalTextStyle.current.copy(
        fontSize = 35.sp,
        textAlign = TextAlign.End
    ), label = {Text("Result", fontSize = 30.sp)},modifier=modifier.padding(25.dp).offset(0.dp,650.dp).width(350.dp).height(80.dp),
        colors = OutlinedTextFieldDefaults.colors(
        disabledTextColor = Color.Black,      // Keeps the numbers bright
        disabledBorderColor = Color.Green,     // Keeps the border sharp
        disabledLabelColor = Color.Gray,


    ))

    //Column(modifier=modifier.fillMaxSize().padding(32.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        //Text("${exactWidthPx}", fontSize = 20.sp, style = MaterialTheme.typography.bodyLarge)

}


