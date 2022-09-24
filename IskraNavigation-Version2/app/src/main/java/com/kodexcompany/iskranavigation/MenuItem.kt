package com.kodexcompany.iskranavigation

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id : String,
    val title : String,
    val contentDescription: String,
    val icon : ImageVector
)