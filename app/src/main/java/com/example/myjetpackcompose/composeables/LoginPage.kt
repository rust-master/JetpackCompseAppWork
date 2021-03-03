package com.example.myjetpackcompose.composeables

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.R
import com.example.myjetpackcompose.ui.theme.primaryColor
import com.example.myjetpackcompose.ui.theme.whiteBackground

@Preview
@Composable
fun LoginPage()
{
    val painter = painterResource(id = R.drawable.logo)
    val emailValue = remember{ mutableStateOf("") }
    val passwordValue = remember{ mutableStateOf("") }

    val passwordVisibility = remember{mutableStateOf(false)}

    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.BottomCenter){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White), contentAlignment = Alignment.TopCenter ) {

            Image(
                painter,
                contentDescription = null,
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(RoundedCornerShape(topStart = 30.dp,topEnd = 30.dp))
                .background(whiteBackground)
                .padding(10.dp)

        ) {
            Text(
                text = "Sign In",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 20.sp,
                ),
                fontSize = 30.sp,
            )

        Spacer(modifier = Modifier.padding(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = emailValue.value,
                onValueChange = { emailValue.value = it },
                label = {Text(text = "Email Address")},
                placeholder = { Text(text = "Email")},
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            OutlinedTextField(
                value = passwordValue.value,
                onValueChange = { passwordValue.value = it },
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility.value = !passwordVisibility.value
                    }) {

                        Icon(painter = painterResource(id = R.drawable.ic_baseline_pass), contentDescription =null,
                            tint = if (passwordVisibility.value) primaryColor else Color.Gray
                            )
                    }
                },
                label = { Text(text = "Password")},
                placeholder = { Text(text = "Password")},
                singleLine = true,
                visualTransformation = if(passwordVisibility.value) VisualTransformation.None
                else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
                ) {
                Text(text = "Sign In",fontSize = 20.sp)
            }
            Spacer(modifier = Modifier.padding(20.dp))
            Text(text = "Create An Account",
                modifier = Modifier.clickable(onClick = {})
                )
            Spacer(modifier = Modifier.padding(20.dp))

        }
        }
    }
}

