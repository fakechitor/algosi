package workpad4

private fun getDeiValue(n: Int): Int {
    return if (n == 1) 1
    else if (n % 2 == 0) getDeiValue(n / 2)
    else getDeiValue(n / 2) + getDeiValue(n / 2 + 1)
}

fun main() {
    val a = getDeiValue(10)
    println(a)
}
