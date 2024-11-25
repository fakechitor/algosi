package workpad3

import java.math.BigInteger

fun addBigNumbers(num1: IntArray, num2: IntArray): IntArray {
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
    val (larger, smaller) = if (compareBigNumbers(num1, num2) >= 0) num1 to num2 else num2 to num1
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

    return removeLeadingZeros(result)
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
    for (i in cleanedNumber.size - 1 downTo 0) {
        print(cleanedNumber[i])
    }
    println()
}

fun stringToIntArray(number: String): IntArray {
    return number.reversed().map { it.digitToInt() }.toIntArray()
}


fun main() {
    val num1 = intArrayOf(4, 3, 2, 1)
    val num2 = intArrayOf(7, 6, 5, 4)
    var sum = addBigNumbers(num1, num2)
    println("Сумма:")
    printNumber(sum)

    val num3 = intArrayOf(8, 7, 6, 5)
    val num4 = intArrayOf(3, 2, 1)
    val difference = subtractBigNumbers(num3, num4)
    println("Разность:")
    printNumber(difference)
    val bigNumberStr = "64732467326487326847326487326472637426378432423423546573248732947832748932742847932472374924627386482736487236472784628764823678462874638"
    val bigNumber2Str = "73847294723974893274723498234723874892748374897247387429473974827498327947328479273984728483274927439287492374893247392"
    val bigNumber = stringToIntArray(bigNumberStr)
    val bigNumber2 = stringToIntArray(bigNumber2Str)
    sum = addBigNumbers(bigNumber, bigNumber2)
    print("Сумма: ")
    printNumber(sum)
    val bigInt1 = BigInteger(bigNumberStr)
    val bigInt2 = BigInteger(bigNumber2Str)
    val bigIntSum = bigInt1 + bigInt2
    println("Сумма (BigInteger): $bigIntSum")
}
