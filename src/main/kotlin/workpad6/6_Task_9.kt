package workpad6

import java.io.File
import java.util.ArrayDeque

fun main() {
    val file = File("src/main/kotlin/resources/input.txt")
    file.forEachLine { line ->
        val stack = ArrayDeque<Char>()
        for (ch in line) {
            stack.push(ch)
        }
        while (stack.isNotEmpty()) {
            print(stack.pop())
        }
        println()
    }
}
