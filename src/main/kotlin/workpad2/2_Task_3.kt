package workpad2import
import kotlin.math.*
private var k=0
fun main() {
    methodFermat(17)
    methodFermat(18)
    methodFermat(27)
    methodFermat(405)
}
fun methodFermat(number : Long){
    k++ ;if (number %2 == 0L){
        println("Testcase$k. $number: нет")
    }
    else {
        val factors = factorize(number)
        val primeFactors = getPrimeFactors(factors)
        var counter = primeFactors.size
        print("Testcase$k. $number: ")
        primeFactors.forEach { (factor, count) ->
            if (counter > 1)  {
                print("$factor ^ $count * ")
                counter--
            }else{ print("$factor ^ $count") }
        };println()
    }
}

fun factorize(n: Long): List<Long> {
    if (n == 1L) return emptyList()
    if (isPrime(n)) return listOf(n)

    val factors = mutableListOf<Long>()
    var a = ceil(sqrt(n.toDouble())).toLong()
    var b2 = a * a - n
    while (!isPerfectSquare(b2)) {
        a++; b2 = a * a - n
    }
    val b = sqrt(b2.toDouble()).toLong()
    val factor1 = a - b
    val factor2 = a + b
    if (factor1 != 1L && factor1 != n) factors.addAll(factorize(factor1)) else factors.add(factor1)
    if (factor2 != 1L && factor2 != n) factors.addAll(factorize(factor2)) else factors.add(factor2)
    return factors.filter { it != 1L }
}
fun isPerfectSquare(number: Long): Boolean {
    val sqrt = sqrt(number.toDouble()).toLong()
    return sqrt * sqrt == number
}
fun getPrimeFactors(factors: List<Long>): Map<Long, Int> {
    val sieve = sieveOfEratosthenes(factors.maxOrNull() ?: 1)
    val primeCount = mutableMapOf<Long, Int>()
    factors.forEach { factor ->
        if (sieve[factor.toInt()]) {
            primeCount[factor] = primeCount.getOrDefault(factor, 0) + 1
        }
    }
    return primeCount
}
fun sieveOfEratosthenes(limit: Long): BooleanArray {
    val sieve = BooleanArray((limit + 1).toInt()) { true }
    sieve[0] = false
    sieve[1] = false

    for (i in 2..sqrt(limit.toDouble()).toInt()) {
        if (sieve[i]) {
            for (j in i * i until sieve.size step i) {
                sieve[j] = false
            }
        }
    }
    return sieve
}
fun isPrime(n: Long): Boolean {
    if (n < 2) return false
    for (i in 2..sqrt(n.toDouble()).toLong()) {
        if (n % i == 0L) return false
    }
    return true
}