package workpad2

fun main() {
    printPrimeNums(10)
}

private fun printPrimeNums(n : Int) {
    val primes = sieveOfSundaram(n)
    print(primes)
}

private fun sieveOfSundaram(n: Int): List<Int> {
    val limit = (n - 1) / 2
    val marked = BooleanArray(limit + 1)

    for (i in 1..limit) {
        var j = i
        while (i + j + 2 * i * j <= limit) {
            marked[i + j + 2 * i * j] = true
            j++
        }
    }

    val primes = mutableListOf(2)
    for (i in 1..limit) {
        if (!marked[i]) {
            primes.add(2 * i + 1)
        }
    }
    return primes
}
