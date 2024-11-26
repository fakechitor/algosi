package workpad3

import kotlin.math.max

fun decimalAdditionAccelerated(num1: IntArray, num2: IntArray): IntArray {
    val maxSize = max(num1.size, num2.size)
    var n1 = num1.copyOf(maxSize + 1)
    var n2 = num2.copyOf(maxSize + 1)
    var buffer = IntArray(n1.size)
    var shift = IntArray(n1.size)
    var step = 1
    while (true) {
        println("Step $step:")
        for (i in n1.indices) {
            if (i != n1.size) {
                buffer[i] = (n1[i] + n2[i]) % 10
            }
            if (i != 0 && n1[i - 1] + n2[i - 1] > 9) {
                shift[i] = 1
            } else {
                shift[i] = 0
            }
        }
        println(buffer.reversedArray().dropWhile { it == 0 }.joinToString(""))
        println(shift.reversedArray().dropWhile { it == 0 }.joinToString(""))
        println()
        if (shift.all { it == 0 }) break
        n1 = buffer
        n2 = shift
        buffer = IntArray(n1.size)
        shift = IntArray(n1.size)
        step++
    }
    return buffer.reversedArray().dropWhile { it == 0 }.toIntArray()
}
fun stringToDecimalArray(decimal: String): IntArray {
    return decimal.reversed().map { it.digitToInt() }.toIntArray()
}
fun printDecimalArray(decimalArray: IntArray) {
    println(decimalArray.joinToString(""))
}
fun main() {
    val decimal1 = "12345"
    val decimal2 = "6789"
    println("num1: $decimal1")
    println("num2: $decimal2")
    println()
    val num1 = stringToDecimalArray(decimal1)
    val num2 = stringToDecimalArray(decimal2)
    val result = decimalAdditionAccelerated(num1, num2)
    println("result:")
    printDecimalArray(result)
}
