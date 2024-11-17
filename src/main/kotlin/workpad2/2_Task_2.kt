package workpad2
import kotlin.math.sqrt
private var k =0
private fun sieveOfEratosthenes(limit: Int): List<Int> {
    val isPrime = BooleanArray(limit + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..sqrt(limit.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * i..limit step i) {
                isPrime[j] = false
            }
        }
    }
    return (2..limit).filter { isPrime[it] }
}
private fun factorizeNumber(n: Int): Map<Int, Int> {
    k++
    var number = n
    val primeDivisors = mutableMapOf<Int, Int>()
    val primes = sieveOfEratosthenes(sqrt(n.toDouble()).toInt())
    for (prime in primes) {
        while (number % prime == 0) {
            primeDivisors[prime] = primeDivisors.getOrDefault(prime, 0) + 1
            number /= prime
        }
    }
    if (number > 1) {
        primeDivisors[number] = primeDivisors.getOrDefault(number, 0) + 1
    }
    return primeDivisors
}
private fun printAnswer(number: Int) {
    val mapOfNumbers = factorizeNumber(number)
    val answerString = mutableListOf<String>()
    for (key in mapOfNumbers.keys) {
        val value = mapOfNumbers[key]
        answerString += "$key^$value"
    }
    print("Testcase$k: $number = ${answerString[0]}")
    for (el in 1..<answerString.size) {
        print(" * ${answerString[el]}")
    }
    println()
}
fun main() {
    printAnswer(17)
    printAnswer(18)
}