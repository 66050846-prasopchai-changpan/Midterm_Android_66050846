package com.example.midterm_66050846

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midterm_66050846.ui.theme.Midterm_66050846Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { Midterm_66050846Theme { FormScreen() } }
    }
}

@Composable
fun FormScreen() {
    val ctx = LocalContext.current
    var name by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var from by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(id = R.color.bg_green)
    ) { inner ->
        Column(
            modifier = Modifier
                .padding(inner)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start ,
            verticalArrangement = Arrangement.Center
        ) {
            // หัวข้อ
            Text(
                text = stringResource(R.string.title_create_card),
                color = colorResource(R.color.red_600),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(24.dp))

            // Row: Happy Birthday to
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.label_to),
                    color = colorResource(R.color.pink),
                    modifier = Modifier.padding(end = 8.dp, bottom = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text(stringResource(R.string.hint_name)) },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(Modifier.height(12.dp))

            // Row: Date
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.label_date),
                    color = colorResource(R.color.pink),
                    modifier = Modifier.padding(end = 8.dp, bottom = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = date,
                    onValueChange = { date = it },
                    placeholder = { Text(stringResource(R.string.hint_date)) },
                    modifier = Modifier.weight(1f),
                )
            }

            Spacer(Modifier.height(12.dp))

            // Row: From
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.label_from),
                    color = colorResource(R.color.pink),
                    modifier = Modifier.padding(end = 8.dp, bottom = 8.dp),
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = from,
                    onValueChange = { from = it },
                    placeholder = { Text(stringResource(R.string.hint_from)) },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(Modifier.height(24.dp))
            Button(
                onClick = {
                    if (name.isBlank() || date.isBlank() || from.isBlank()) {
                        Toast.makeText(ctx, ctx.getString(R.string.err_required), Toast.LENGTH_SHORT).show()
                        return@Button
                    }
                    val data = BirthdayData(name, date, from)
                    val key = ctx.getString(R.string.key_birthday_data)
                    ctx.startActivity(Intent(ctx, CardActivity::class.java).putExtra(key, data))
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) { Text(stringResource(R.string.btn_create)) }
        }
    }
}

