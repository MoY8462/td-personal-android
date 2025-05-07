package com.example.td_personal.HomeScreen.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.td_personal.HomeScreen.Presentation.ViewModel.HomeViewModel
import com.example.td_personal.R

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = viewModel()
    // Observar los datos del ViewModel
    val carrouselItems by homeViewModel.carrouselItems.collectAsState()

    homeViewModel.loadCarrouselItems()

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
        ImageCarousel()
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            carrouselItems.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    // Aquí puedes cargar la imagen desde una URL si usas una librería como Coil
                    Text(
                        text = item.imageUrl,
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.dark_300)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageCarousel() {
    val images = listOf(
        R.drawable.respuesta_pliego, // Reemplaza con tus recursos de imagen
        R.drawable.respuesta_pliego,
        R.drawable.respuesta_pliego
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        images.forEach { imageRes ->
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .width(400.dp)
                    .height(150.dp)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}