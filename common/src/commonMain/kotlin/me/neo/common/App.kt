package me.neo.common

import StopWatch
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun App() {

    val stopWatch = remember { StopWatch() }

    StopWatchScreen(
        formattedTime = stopWatch.formattedTime,
        onStartClick = {
            stopWatch.start()
        },
        onPauseClick = {
            stopWatch.pause()
        },
        onResetClick = {
            stopWatch.reset()
        },
        modifier = Modifier.fillMaxSize()
    )
}
