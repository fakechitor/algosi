package workpad4

fun hanoi(n: Int, from: String, to: String, auxiliary: String) {
    if (n == 1) {
        println("переместить кольцо 1 с $from на $to")
        return
    }
    hanoi(n - 1, from, auxiliary, to)
    println("переместить кольцо $n с $from на $to")
    hanoi(n - 1, auxiliary, to, from)
}

fun main() {
    val ringsAmount = 3
    hanoi(ringsAmount, "A", "C", "B")
}
