package me.bastanfar.lemonade.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.bastanfar.lemonade.ui.theme.LemonadeTheme
import me.bastanfar.lemonade.viewmodel.LemonadeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp(
    lemonadeViewModel:LemonadeViewModel = viewModel()
) {
    val lemonadeUiState by lemonadeViewModel.uiState.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
    ) {
        LemonTextAndImage(
            currentStepTextResourceId = lemonadeUiState.currentStepTextResourceId,
            currentStepImageResourceId = lemonadeUiState.currentStepImageResourceId,
            currentImageDescriptionResourceId = lemonadeUiState.currentStepImageDescriptionResourceId,
            onImageClick = { lemonadeViewModel.onImageClicked() }
        )
    }
}

@Composable
fun LemonTextAndImage(
    currentStepTextResourceId: Int,
    currentStepImageResourceId: Int,
    currentImageDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(currentStepTextResourceId),
            fontSize = 18.sp,
        )
        Spacer(modifier = modifier.height(16.dp))
        Image(
            painter = painterResource(id = currentStepImageResourceId),
            contentDescription = stringResource(id = currentImageDescriptionResourceId),
            modifier
                .border(
                    BorderStroke(
                        width = 2.dp,
                        color = Color(105, 205, 216),
                    ),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable(onClick = onImageClick)
                .padding(all = 16.dp)
        )
    }
}

@Preview
@Composable
fun LemonAppPreview() {
    LemonApp()
}