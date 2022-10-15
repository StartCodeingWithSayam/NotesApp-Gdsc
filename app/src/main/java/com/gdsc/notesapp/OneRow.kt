package com.gdsc.notesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdsc.notesapp.models.Data

@Composable
fun OneRow(data: Data, onClick: () ->Unit) {
    Row(modifier = Modifier.clickable {
        onClick.invoke()
    }){
        Image(
            painter = painterResource(id = data.imageId),
            contentDescription = "image",
            modifier = Modifier
                .padding(5.dp)
                .clip(RoundedCornerShape(CornerSize(10.dp)))
                .size(124.dp)
        )
        Spacer(modifier = Modifier.width(23.dp))
        Text(
            text = data.imgDis,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White
        )
    }
}