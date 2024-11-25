package workpad4

private fun fibonacci(n: Int): Int {
    if (n <= 1) {
        return 0
    }
    if (n <= 3) {
        return 1
    }
    return fibonacci(n - 1) + fibonacci(n - 2)
}

fun main() {
    val n = readln().toInt()
    println("число фибоначчи ($n) = ${fibonacci(n)}")
}
