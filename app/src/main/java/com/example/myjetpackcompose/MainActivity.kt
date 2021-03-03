package com.example.myjetpackcompose


import android.content.Context
import android.os.Bundle
import android.widget.Toast

import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myjetpackcompose.ui.theme.MyJetpackComposeTheme



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(16.dp)
                    )
                    {
                        Image(
                            painter = painterResource(R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier
                                .height(180.dp)
                                .width(180.dp)
                                .clip(shape = RoundedCornerShape(4.dp)),
                        contentScale = ContentScale.Crop

                        )
                        TextLogin("Login")
                        ButtonAction(applicationContext)
                    }

                }
            }
        }
    }

}


@Composable
fun TextLogin(s: String) {
    Text(s)
}

@Composable
fun ButtonAction(context: Context) {
    Button(onClick = {
        Toast.makeText(
            context,
            "Jetpack Compose",
            Toast.LENGTH_SHORT
        ).show()
    }) {
        Icon(
            Icons.Filled.Favorite,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )

        Text("Like")
    }
}




