package com.bosseurs.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bosseurs.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,

                ) {
                    BirthdayCard(message = stringResource(R.string.happy_birthday_name), from = stringResource(R.string.signature_text))
                }
            }
        }
    }
}

@Composable
fun BirthdayCard(message : String, from : String){
    val image = painterResource(id = R.drawable.androidparty)
    Box() {
        Image(painter = image, contentDescription = "Birthday Party", contentScale = ContentScale.Crop)
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){
            Text(message,
                style = TextStyle(fontSize = 36.sp),
            modifier = Modifier.padding(top = 16.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(from, style = TextStyle(fontSize = 25.sp),
                modifier = Modifier.padding(top = 16.dp)


                )


        }
    }

}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview(){
    BirthdayCard(message = stringResource(R.string.happy_birthday_name), from = stringResource(R.string.signature_text))
}
