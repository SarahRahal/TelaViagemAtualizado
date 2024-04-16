package com.example.novaviagematualizado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.novaviagematualizado.components.MyTopBar
import com.example.novaviagematualizado.ui.theme.NovaViagemAtualizadoTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NovaViagemAtualizadoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Myapp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Myapp() {
    Scaffold(
        topBar = {
            MyTopBar()
        }
    ) {
        var showDatePickerDialogDtInicio = remember {
            mutableStateOf(false)
        }
        var selectedDateDtInicio = remember {
            mutableStateOf("")
        }
        val datePickerStateDtInicio = rememberDatePickerState()

        var showDatePickerDialogDtFinal = remember {
            mutableStateOf(false)
        }
        var selectedDateDtFinal = remember {
            mutableStateOf("")
        }
        val datePickerStateDtFinal = rememberDatePickerState()

        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Destino da Viagem!",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .weight(1f)
                )
            }
            Row {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .weight(4f)
                        .padding(top = 10.dp)
                )
            }
            Row {
                Text(
                    text = "Tipo",
                    fontSize = 22.sp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 10.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = false,
                    onClick = {},
                    modifier = Modifier
                        .weight(0.5f)
                )
                Text(
                    text = "Lazer",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .weight(1.5f)
                )
                RadioButton(
                    selected = false,
                    onClick = {},
                    modifier = Modifier
                        .weight(0.5f)
                )
                Text(
                    text = "Negócios",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .weight(1.5f)
                )
            }
            Row {
                Text(
                    text = "Data Inicio",
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1.5f)
                        .padding(top = 16.dp)
                )
            }
            Row {
                if (showDatePickerDialogDtInicio.value) {
                    DatePickerDialog(
                        onDismissRequest = { showDatePickerDialogDtInicio.value = false },
                        confirmButton = {
                            Button(
                                onClick = {
                                    datePickerStateDtInicio
                                        .selectedDateMillis?.let { millis ->
                                            selectedDateDtInicio.value =
                                                millis.toBrazilianDateFormat()
                                        }
                                    showDatePickerDialogDtInicio.value = false
                                }) {
                                Text(text = "Escolher data")
                            }
                        },
                        modifier = Modifier
                            .weight(4f)
                    ) {
                        DatePicker(state = datePickerStateDtInicio)
                    }
                }
                OutlinedTextField(
                    value = selectedDateDtInicio.value,
                    onValueChange = { },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .onFocusChanged {
                            if (it.isFocused) {
                                showDatePickerDialogDtInicio.value = true
                            }
                        },
                    readOnly = true
                )
            }

            Row {
                Text(
                    text = "Data Final",
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .weight(1.5f)
                        .padding(top = 16.dp)
                )
            }
            Row {
                if (showDatePickerDialogDtFinal.value) {
                    DatePickerDialog(
                        onDismissRequest = { showDatePickerDialogDtFinal.value = false },
                        confirmButton = {
                            Button(
                                onClick = {
                                    datePickerStateDtFinal
                                        .selectedDateMillis?.let { millis ->
                                            selectedDateDtFinal.value =
                                                millis.toBrazilianDateFormat()
                                        }
                                    showDatePickerDialogDtFinal.value = false
                                }) {
                                Text(text = "Escolher data")
                            }
                        },
                        modifier = Modifier
                            .weight(4f)
                    ) {
                        DatePicker(state = datePickerStateDtFinal)
                    }
                }
                OutlinedTextField(
                    value = selectedDateDtFinal.value,
                    onValueChange = { },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .onFocusChanged {
                            if (it.isFocused) {
                                showDatePickerDialogDtFinal.value = true
                            }
                        },
                    readOnly = true
                )
            }

            Row {
                Text(
                    text = "Orçamento",
                    fontSize = 22.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .weight(1.5f)
                        .padding(top = 16.dp)
                )
            }
                Row {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier
                            .weight(4f)
                            .padding(top = 10.dp)
                    )
                }

                Row {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(top = 25.dp)
                    ) {
                        Text(text = "Salvar")
                    }
                }
            }
        }
    }

fun Long.toBrazilianDateFormat(
    pattern: String = "dd/MM/yyyy"
): String {
    val date = Date(this)
    val formatter = SimpleDateFormat(
        pattern, Locale("pt-br")
    ).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }
    return formatter.format(date)
}