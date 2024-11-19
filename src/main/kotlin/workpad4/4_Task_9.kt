package workpad4

fun main() {
    val input = readlnOrNull() ?: ""

    val charCount = mutableMapOf<Char, Int>()

    for (char in input) {
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }

    println(charCount.toString())
}
