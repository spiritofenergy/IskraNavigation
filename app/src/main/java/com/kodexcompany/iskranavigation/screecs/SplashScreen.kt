package com.kodexcompany.iskranavigation.screecs

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material.Icon
import com.kodexcompany.iskranavigation.MainViewModel
import com.kodexcompany.iskranavigation.navigation.Screens
import com.kodexcompany.iskranavigation.ui.theme.IskraNavigationTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen (navHostController: NavHostController, viewModel: MainViewModel){
    var startAnimate by remember { mutableStateOf(false) }
    val alfaAnimation = animateFloatAsState(
        targetValue = if (startAnimate) 1f else 0f,
    animationSpec = tween(durationMillis = 3000)
    )
    LaunchedEffect(key1 = true){
        startAnimate = true
        viewModel.getAllMovies()
        delay(4000)
        navHostController.navigate(Screens.Main.route)
    }
    Splash(alpha  = alfaAnimation.value)
}
@Composable
fun Splash(alpha: Float){
    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
    ){
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            imageVector = Icons.Default.PlayArrow,
            tint = Color.Black,
            contentDescription = ""
        )
    }
}

@Composable
@Preview(showBackground = true)
fun prevSplash(){
    IskraNavigationTheme{
        Splash(1f)
    }
}