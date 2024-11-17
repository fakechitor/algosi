package workpad4

fun hanoi(n: Int, from: String, to: String, auxiliary: String) {
    if (n == 1) {
        println("Переместить кольцо 1 с $from на $to")
        return
    }
    hanoi(n - 1, from, auxiliary, to)
    println("Переместить кольцо $n с $from на $to")
    hanoi(n - 1, auxiliary, to, from)
}

fun main() {
    val ringsAmount = 4
    hanoi(ringsAmount, "A", "C", "B")
}
