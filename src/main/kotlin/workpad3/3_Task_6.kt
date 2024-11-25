package workpad3

import java.math.BigInteger


fun divideHalfDivision(dividend: String, divisor: String): Pair<String, String> {
    if (divisor == "0") throw ArithmeticException("Деление на ноль невозможно.")
    if (dividend == "0") return "0" to "0"

    val divisorInt = divisor.toBigInteger()
    val dividendInt = dividend.toBigInteger()
    if (dividendInt < divisorInt) return "0" to dividend // Если делимое меньше делителя

    // Инициализируем границы поиска
    var low = BigInteger.ZERO
    var high = dividendInt
    var quotient = BigInteger.ZERO

    // Метод половинного деления
    while (low <= high) {
        val mid = (low + high) / BigInteger.valueOf(2)
        val product = mid * divisorInt

        if (product <= dividendInt) {
            quotient = mid
            low = mid + BigInteger.ONE
        } else {
            high = mid - BigInteger.ONE
        }
    }

    // Остаток: делимое - (частное * делитель)
    val remainder = dividendInt - (quotient * divisorInt)

    return quotient.toString() to remainder.toString()
}

fun main() {
    val dividend = "378731279371297392794326746327846327848364786327432483264872367846237483264873264327846832764234317932187392179371837921873981728319"
    val divisor = "3781273281937463724687328463287467326487264"
    println("divided: $dividend")
    println("divisor: $divisor")
    println()

    val (quotient, remainder) = divideHalfDivision(dividend, divisor)
    println("quotient: $quotient")
    println("remainder: $remainder")

    val bigIntQuotient = dividend.toBigInteger() / divisor.toBigInteger()
    val bigIntRemainder = dividend.toBigInteger() % divisor.toBigInteger()
    println("quotient (BigInteger): $bigIntQuotient")
    println("remainder (BigInteger): $bigIntRemainder")

}
