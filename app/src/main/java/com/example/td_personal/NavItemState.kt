package com.example.td_personal

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItemState(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)
