package com.gdsc.notesapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdsc.notesapp.models.SettingsModel

@Composable
fun SettingsUi(settingsData:SettingsModel,
               onClick: ()->Unit) {
    Card(
        shape = RoundedCornerShape(percent = 12),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 2.dp,
        border = BorderStroke(1.dp,MaterialTheme.colors.onPrimary),
        modifier = Modifier.clickable { onClick.invoke() }
    ){
        Row(
            modifier = Modifier
                .padding(top = 9.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 15.dp, start = 23.dp, bottom = 23.dp),
                text = settingsData.imgDis,
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontSize = 27.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(234.dp))
            Icon(
                painter = painterResource(id = settingsData.imageId),
                contentDescription = settingsData.imgDis,
                modifier = Modifier
                    .size(34.dp)
                    .padding(23.dp)
            )
        }
    }
}
