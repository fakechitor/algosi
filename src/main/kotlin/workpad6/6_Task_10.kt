package workpad6

import java.io.File
import java.util.ArrayDeque

fun main() {
    val file = File("src/main/kotlin/resources/numbers.txt")
    val singleDigitQueue = ArrayDeque<Int>()
    val twoDigitQueue = ArrayDeque<Int>()

    file.forEachLine { line ->
        val tokens = line.split(Regex("\\s+")).filter { it.isNotEmpty() }
        for (token in tokens) {
            val num = token.toIntOrNull() ?: continue
            if (num in 1..9) {
                singleDigitQueue.add(num)
            } else if (num in 10..99) {
                twoDigitQueue.add(num)
            }
        }
    }

    while (singleDigitQueue.isNotEmpty()) {
        print("${singleDigitQueue.removeFirst()} ")
    }

    while (twoDigitQueue.isNotEmpty()) {
        print("${twoDigitQueue.removeFirst()} ")
    }
}
