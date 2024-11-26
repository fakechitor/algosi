package workpad3

private fun binaryAdditionAccelerated(num1: IntArray, num2: IntArray): IntArray {
    val maxSize = maxOf(num1.size, num2.size)
    val n1 = num1.copyOf(maxSize + 1)
    val n2 = num2.copyOf(maxSize + 1)
    var buffer = IntArray(n1.size)
    var shift = IntArray(n1.size)
    var step = 1
    while (true) {
        println("step $step:")
        for (i in n1.indices) {
            buffer[i] = (n1[i] xor n2[i])
            if (i > 0 && n1[i - 1] + n2[i - 1] == 2) {
                shift[i] = 1
            } else {
                shift[i] = 0
            }
        }
        println(buffer.reversedArray().joinToString(""))
        println(shift.reversedArray().joinToString(""))
        println()
        if (shift.all { it == 0 }) break
        for (i in n1.indices) {
            n1[i] = buffer[i]
            n2[i] = shift[i]
        }

        buffer = IntArray(n1.size)
        shift = IntArray(n2.size)
        step++
    }
    return buffer.reversedArray()
}
private fun stringToBinaryArray(binary: String): IntArray {
    return binary.reversed().map { it.digitToInt() }.toIntArray()
}
private fun printBinaryArray(binaryArray: IntArray) {
    println(binaryArray.joinToString(""))
}
fun main() {
    val binary1 = "1101011"
    val binary2 = "1011101"
    println("number1: $binary1")
    println("number2: $binary2")
    println()

    val num1 = stringToBinaryArray(binary1)
    val num2 = stringToBinaryArray(binary2)

    val result = binaryAdditionAccelerated(num1, num2)

    println("final result:")
    printBinaryArray(result)

}
