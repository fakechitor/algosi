package workpad3

import java.math.BigInteger



fun karatsubaMultiply(num1: String, num2: String): String {
    if (num1.length == 1 || num2.length == 1) {
        return (num1.toLong() * num2.toLong()).toString()
    }

    val maxLength = maxOf(num1.length, num2.length)
    val halfLength = (maxLength + 1) / 2

    val high1 = if (num1.length > halfLength) num1.substring(0, num1.length - halfLength) else "0"
    val low1 = num1.substring(num1.length - halfLength)
    val high2 = if (num2.length > halfLength) num2.substring(0, num2.length - halfLength) else "0"
    val low2 = num2.substring(num2.length - halfLength)

    val z0 = karatsubaMultiply(low1, low2)
    val z1 = karatsubaMultiply(addStrings(low1, high1), addStrings(low2, high2))
    val z2 = karatsubaMultiply(high1, high2)

    val result = addStrings(
        addStrings(
            z2 + "0".repeat(2 * halfLength),
            subtractStrings(z1, addStrings(z2, z0)) + "0".repeat(halfLength)
        ),
        z0
    )
    return result.trimStart('0')
}

fun addStrings(num1: String, num2: String): String {
    val sb = StringBuilder()
    var carry = 0
    var i = num1.length - 1
    var j = num2.length - 1

    while (i >= 0 || j >= 0 || carry > 0) {
        val x = if (i >= 0) num1[i--] - '0' else 0
        val y = if (j >= 0) num2[j--] - '0' else 0
        val sum = x + y + carry
        sb.append(sum % 10)
        carry = sum / 10
    }

    return sb.reverse().toString()
}

fun subtractStrings(num1: String, num2: String): String {
    val sb = StringBuilder()
    var borrow = 0
    var i = num1.length - 1
    var j = num2.length - 1

    while (i >= 0 || j >= 0) {
        val x = if (i >= 0) num1[i--] - '0' else 0
        val y = if (j >= 0) num2[j--] - '0' else 0
        var diff = x - y - borrow
        if (diff < 0) {
            diff += 10
            borrow = 1
        } else {
            borrow = 0
        }
        sb.append(diff)
    }

    return sb.reverse().toString().trimStart('0')
}

fun main() {
    val num1 = "32248234782349273894792873424782343274923749238749324392"
    val num2 = "843904789237493278497239847293874973247932"
    println("num1: $num1")
    println("num2: $num2")

    val resultColumn = multiplyLargeNumbers(num1, num2)
    println("result): $resultColumn")

    val resultKaratsuba = karatsubaMultiply(num1, num2)
    println("result (karatsuba): $resultKaratsuba")

    val bigIntNum1 = BigInteger(num1)
    val bigIntNum2 = BigInteger(num2)
    val resultBigInteger = bigIntNum1.multiply(bigIntNum2)
    println("result (BigInteger): $resultBigInteger")


}
