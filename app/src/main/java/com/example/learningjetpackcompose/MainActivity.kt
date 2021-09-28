package com.example.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
            Icon(painter = painterResource(id =R.drawable.ic_launcher_background),
                contentDescription = "this is an icon")
            LearningJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}


data class Message(val author:String,val body:String)

@Composable
fun MessageCard( message: Message)
{
    
    Column {

        Text(text = message.author)
        Text(text = message.body)
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription ="this is background",
            modifier = Modifier.size(40.dp)
                .clip(CircleShape)
        )
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearningJetpackComposeTheme {
        MessageCard(Message("Android", "Jetpack Compose"))
    }
}