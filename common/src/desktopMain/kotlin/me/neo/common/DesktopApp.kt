package me.neo.common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Preview
@Composable
fun AppPreview() {
    App()
}

@Composable
@Preview
fun StopWatchScreenPreview() {
    StopWatchScreen(
        "00:00:000",
        onStartClick = {},
        onPauseClick = {},
        onResetClick = {},
        modifier = Modifier.fillMaxSize()
    )
}