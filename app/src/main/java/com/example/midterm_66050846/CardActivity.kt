package com.example.midterm_66050846

import android.graphics.fonts.FontStyle
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midterm_66050846.BirthdayData
import com.example.midterm_66050846.ui.theme.Midterm_66050846Theme
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontStyle as FontStyle1


class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val key = getString(R.string.key_birthday_data)
        val data: BirthdayData? =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getParcelableExtra(key, BirthdayData::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getParcelableExtra<BirthdayData>(key)
            }

        setContent { Midterm_66050846Theme { CardScreen(data) } }
    }
}

@Composable
fun CardScreen(data: BirthdayData?) {
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.androidparty),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,   // ✅ จัดกึ่งกลางแนวนอน
            verticalArrangement = Arrangement.Center              // ✅ จัดกึ่งกลางแนวตั้ง (กลุ่มข้อความ Happy Birthday)
        ) {
            Text(
                text = stringResource(R.string.txt_happy),
                color = colorResource(R.color.pink),
                fontSize = 90.sp
            )

            Text(
                text = stringResource(R.string.txt_birthday),
                color = colorResource(R.color.pink),
                fontSize = 90.sp
            )

            Text(
                text = "${data?.name.orEmpty()}!",
                color = colorResource(R.color.pink),
                fontSize = 90.sp
            )

            Spacer(Modifier.height(16.dp))

            // วันที่ อยู่กลาง
            Text(
                text = data?.date.orEmpty(),
                color = colorResource(R.color.black),
                fontSize = 40.sp,
                fontStyle = FontStyle1.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            // From ... ชิดขวาล่าง
            Text(
                text = stringResource(R.string.prefix_from, data?.fromName.orEmpty()),
                color = colorResource(R.color.blue),
                fontSize = 40.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}