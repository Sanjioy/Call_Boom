import kotlinx.coroutines.*

fun main() = runBlocking {
    val alarms = listOf(5L, 7L, 10L)

    val jobs = alarms.map { duration ->
        launch {
            repeat(duration.toInt()) {
                println(when (duration) {
                    5L -> "Tuck"
                    7L -> "Tack"
                    10L -> "Tick"
                    else -> ""
                })
                delay(1_000)
            }
            println("BOOM")
        }
    }

    delay(15_000)
    jobs.forEach { it.cancel() }
}
