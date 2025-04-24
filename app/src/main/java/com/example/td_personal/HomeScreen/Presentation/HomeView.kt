package com.example.td_personal.HomeScreen.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.td_personal.R

@Composable
fun HomeScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        //Text(text = "Inicio", fontSize = 32.sp)
        //Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.paper), // Reemplaza 'tu_imagen' con el nombre de tu imagen
                contentDescription = "Papel", // Descripción para accesibilidad
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop // Ajusta como quieras que la imagen se ajuste
            )
            Text(text = "Noticias",
                fontSize = 22.sp,
                color = colorResource(id = R.color.blue),
                fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.clock), // Reemplaza 'tu_imagen' con el nombre de tu imagen
                contentDescription = "Papel", // Descripción para accesibilidad
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Crop // Ajusta como quieras que la imagen se ajuste
            )
            Text(text = "Horario en ventanillas",
                fontSize = 22.sp,
                color = colorResource(id = R.color.blue),
                fontWeight = FontWeight.Bold)
        }

    }
}