package workpad3

fun addBigNumbers(num1: IntArray, num2: IntArray, isNegative1: Boolean = false, isNegative2: Boolean = false): IntArray {
    return when {
        !isNegative1 && !isNegative2 -> addUnsignedBigNumbers(num1, num2)
        isNegative1 && isNegative2 -> addUnsignedBigNumbers(num1, num2).also { it[it.size - 1] = -it[it.size - 1] }
        isNegative1 -> subtractBigNumbers(num2, num1)
        else -> subtractBigNumbers(num1, num2)
    }
}

fun addUnsignedBigNumbers(num1: IntArray, num2: IntArray): IntArray {
    val maxSize = maxOf(num1.size, num2.size)
    val result = IntArray(maxSize + 1)
    var carry = 0

    for (i in 0 until maxSize) {
        val digit1 = if (i < num1.size) num1[i] else 0
        val digit2 = if (i < num2.size) num2[i] else 0
        val sum = digit1 + digit2 + carry
        result[i] = sum % 10
        carry = sum / 10
    }

    if (carry != 0) {
        result[maxSize] = carry
    }

    return result
}

fun subtractBigNumbers(num1: IntArray, num2: IntArray): IntArray {
    val (larger, smaller, isNegative) = if (compareBigNumbers(num1, num2) >= 0) {
        Triple(num1, num2, false)
    } else {
        Triple(num2, num1, true)
    }
    val result = IntArray(larger.size)
    var borrow = 0
    for (i in 0 until larger.size) {
        val digit1 = larger[i]
        val digit2 = if (i < smaller.size) smaller[i] else 0
        var diff = digit1 - digit2 - borrow

        if (diff < 0) {
            diff += 10
            borrow = 1
        } else {
            borrow = 0
        }

        result[i] = diff
    }
    val cleanedResult = removeLeadingZeros(result)
    return if (isNegative) cleanedResult.also { it[it.size - 1] = -it[it.size - 1] } else cleanedResult
}
fun compareBigNumbers(num1: IntArray, num2: IntArray): Int {
    if (num1.size > num2.size) return 1
    if (num1.size < num2.size) return -1

    for (i in num1.size - 1 downTo 0) {
        if (num1[i] > num2[i]) return 1
        if (num1[i] < num2[i]) return -1
    }
    return 0
}
fun removeLeadingZeros(result: IntArray): IntArray {
    var start = result.size - 1
    while (start > 0 && result[start] == 0) {
        start--
    }
    return result.copyOfRange(0, start + 1)
}
fun printNumber(number: IntArray) {
    val cleanedNumber = removeLeadingZeros(number)
    if (cleanedNumber[cleanedNumber.size - 1] < 0) {
        print("-")
    }
    for (i in cleanedNumber.size - 1 downTo 0) {
        print(kotlin.math.abs(cleanedNumber[i]))
    }
    println()
}
fun stringToIntArray(number: String): Pair<IntArray, Boolean> {
    val isNegative = number.startsWith("-")
    val digits = number.trimStart('-').reversed().map { it.digitToInt() }.toIntArray()
    return Pair(digits, isNegative)
}
fun main() {
    val bigNumberStr = "64732467326487326847326487326472637426378432423423546573248732947832748932742847932472374924627386482736487236472784628764823678462874638"
    val bigNumber2Str = "-73847294723974893274723498234723874892748374897247387429473974827498327947328479273984728483274927439287492374893247392"
    println("num1: $bigNumberStr")
    println("num2: $bigNumber2Str")
    val (bigNumber, isNegative1) = stringToIntArray(bigNumberStr)
    val (bigNumber2, isNegative2) = stringToIntArray(bigNumber2Str)
    val sum = addBigNumbers(bigNumber, bigNumber2, isNegative1, isNegative2)
    print("Сумма: ")
    printNumber(sum)
}
