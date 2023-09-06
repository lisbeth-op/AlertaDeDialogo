package com.example.ejercicio

import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio.ui.theme.EjercicioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjercicioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyAlertDialog()
                    MyTextField()
                }
            }
        }
    }
}
@Composable
fun TextFieldScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyAlertDialog()
        MyTextField()
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    val textValue = remember { mutableStateOf("") }
    TextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label = {}
    )
}

@Composable
fun ExploreButtonsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        MyButton()
        MyRadioGroup()
        MyFloatingActionButton()

    }
}

@Composable
fun MyButton() {
    Button(
        onClick = {},

        border = BorderStroke(
            1.dp,
            color = colorResource(id = R.color.black)
        )
    ) {
        Text(
            text = stringResource(id = androidx.compose.ui.R.string.close_sheet),
            color = androidx.compose.ui.graphics.Color.White
        )
    }
}

@Composable
fun MyRadioGroup() {
    val radioButtons = listOf(0, 1, 2)

    val selectedButton = remember { mutableStateOf(radioButtons.first()) }

    Column {
        radioButtons.forEach { index ->
            index == selectedButton.value



        }
    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        contentColor = androidx.compose.ui.graphics.Color.White,
        content = {
            Icon(Icons.Filled.Favorite, stringResource(androidx.compose.ui.R.string.on))
        }
    )
}
@Composable

fun MyText() {

    //MyButton()
}

@Composable
fun MyAlertDialog() {
    val shouldShowDialog = remember { mutableStateOf(true) } // 1
    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = { // 4
                shouldShowDialog.value = false
                //JetFundamentalsRouter.navigateTo(Screen.Navigation)
            },
            // 5
            title = { Text(text = stringResource(id =
            androidx.compose.material3.R.string.dialog)) },
            text = { Text(text ="Hola, Como esta?" ) },
            confirmButton = { // 6
                Button(

                    onClick = {
                        shouldShowDialog.value = false
                        //JetFundamentalsRouter.navigateTo(Screen.Navigation)
                    }
                ) {
                    Text(
                        text ="Cerrar",
                        color = androidx.compose.ui.graphics.Color.Blue
                    )
                }
            }
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjercicioTheme {
        TextFieldScreen()
    }
}