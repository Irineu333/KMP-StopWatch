import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class StopWatch {

    var formattedTime by mutableStateOf(formatTime(0L))

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var job: Job? = null

    private var timeMillis = 0L
    private var lastTimestamp = 0L

    fun start() {

        if (job?.isActive == true) return

        job = coroutineScope.launch {
            lastTimestamp = System.currentTimeMillis()
            while (true) {
                delay(10L)
                timeMillis += System.currentTimeMillis() - lastTimestamp
                lastTimestamp = System.currentTimeMillis()
                formattedTime = formatTime(timeMillis)
            }
        }
    }

    fun pause() {
        job?.cancel()
    }

    fun reset() {
        job?.cancel()
        timeMillis = 0L
        lastTimestamp = 0L
        formattedTime = formatTime(0L)
    }

    private fun formatTime(timeMillis: Long): String {
        val localDateTime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(timeMillis),
            ZoneId.systemDefault()
        )
        val formatter = DateTimeFormatter.ofPattern(
            "mm:ss:SS",
            Locale.getDefault()
        )

        return localDateTime.format(formatter)
    }
}