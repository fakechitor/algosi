package workpad3

import java.math.BigInteger

fun multiplyLargeNumbers(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"

    val n1 = num1.length
    val n2 = num2.length
    val result = IntArray(n1 + n2) { 0 }

    val num1Reversed = num1.reversed()
    val num2Reversed = num2.reversed()

    for (i in 0 until n1) {
        for (j in 0 until n2) {
            val mul = (num1Reversed[i] - '0') * (num2Reversed[j] - '0')
            val sum = mul + result[i + j]
            result[i + j] = sum % 10
            result[i + j + 1] += sum / 10
        }
    }

    val sb = StringBuilder()
    var i = result.size - 1
    while (i >= 0 && result[i] == 0) {
        i--
    }
    while (i >= 0) {
        sb.append(result[i])
        i--
    }

    return sb.toString()
}

fun main() {
    val num1 = "32248234782349273894792873424782343274923749238749324392"
    val num2 = "843904789237493278497239847293874973247932"
    println("num1: $num1")
    println("num2: $num2")

    val resultCustom = multiplyLargeNumbers(num1, num2)
    println("result: $resultCustom")

    val bigIntNum1 = BigInteger(num1)
    val bigIntNum2 = BigInteger(num2)
    val resultBigInteger = bigIntNum1.multiply(bigIntNum2)
    println("result (BigInteger): $resultBigInteger")

}
