package com.example.td_personal.DocumentScreen.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun DocumentsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Ayudante de profesor de asignatura “A”",
            fontSize = 18.sp,
            color = colorResource(id = R.color.dark_300),
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.doc_error), // Reemplaza 'tu_imagen' con el nombre de tu imagen
                contentDescription = "Documento", // Descripción para accesibilidad
                modifier = Modifier
                    .size(35.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Fit // Ajusta como quieras que la imagen se ajuste
            )
            Column {
                Text(text = "ejemplo_archivo.pdf",
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.blue),
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                )
                Text(text = "Ultimá  modificación 21/11/2024 12:03:34",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.blue),
                    fontWeight = FontWeight.Light,
                )
            }

            Image(
                painter = painterResource(id = R.drawable.cloud_download), // Reemplaza 'tu_imagen' con el nombre de tu imagen
                contentDescription = "Descargar", // Descripción para accesibilidad
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically),
                contentScale = ContentScale.Fit // Ajusta como quieras que la imagen se ajuste
            )

        }

    }
}