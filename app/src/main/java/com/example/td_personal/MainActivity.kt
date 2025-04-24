package com.example.td_personal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.td_personal.ui.theme.TDPersonalTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TDPersonalTheme {
                val items = listOf(
                    NavItemState(
                        title = "Inicio",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home
                    ),
                    NavItemState(
                        title = "Documentos",
                        selectedIcon = Icons.Filled.Email,
                        unselectedIcon = Icons.Outlined.Email
                    ),
                    NavItemState(
                        title = "Calendario",
                        selectedIcon = Icons.Filled.DateRange,
                        unselectedIcon = Icons.Outlined.DateRange
                    ),
                    //NavItemState(
                    //    title = "Movimientos",
                    //    selectedIcon = Icons.Filled.Menu,
                    //    unselectedIcon = Icons.Outlined.Menu
                    //)
                    NavItemState(
                        title = "Perfil",
                        selectedIcon = Icons.Filled.Person,
                        unselectedIcon = Icons.Outlined.Person
                    )
                )
                /*var navBarState by rememberSaveable {
                    mutableIntStateOf(0)
                }*/
                val navController = rememberNavController()

                val currentBackStackEntry by navController.currentBackStackEntryFlow.collectAsStateWithLifecycle(
                    null
                )
                var navBarState = when(currentBackStackEntry?.destination?.route){
                    Home::class.simpleName -> 0
                    Documents::class.simpleName -> 1
                    Calendar::class.simpleName -> 2
                    Account::class.simpleName -> 3
                    else -> -1
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        ToolBar(
                            title = when (navBarState) {
                                0 -> "Hola"
                                1 -> "Documentos"
                                2 -> "Calendario"
                                3 -> "Perfil"
                                else -> "App"
                            }
                        )
                    },
                    bottomBar = {
                        NavigationBar {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = navBarState == index,
                                    onClick = {
                                        navBarState = index
                                        //navController.popBackStack()

                                        when(index){
                                            0 -> navController.navigate(Home::class.simpleName!!)
                                            1 -> navController.navigate(Documents::class.simpleName!!)
                                            2 -> navController.navigate(Calendar::class.simpleName!!)
                                            3 -> navController.navigate(Account::class.simpleName!!)
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (navBarState == index) item.selectedIcon
                                            else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    }, label = {
                                        Text(text = item.title)
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                        ){
                            NavGraph(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun ToolBar(title: String) {
    val backgroundColor = colorResource(R.color.black)
    val textColor = colorResource(R.color.white)
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(text = title,
                fontSize = 22.sp,
                color = colorResource(id = R.color.blue),
                fontWeight = FontWeight.Bold)
        }
    )
}