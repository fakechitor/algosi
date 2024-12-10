package workpad6

fun main() {
    val arr = intArrayOf(1, 0, 0, 2, 0, 0, 3)
    println("[${arr.joinToString(" ")}]")

    val hasTwoZeros = (0 until arr.size - 1).any { arr[it] == 0 && arr[it + 1] == 0 }
    val hasThreeZeros = (0 until arr.size - 2).any { arr[it] == 0 && arr[it + 1] == 0 && arr[it + 2] == 0 }

    println("Has two zeros: $hasTwoZeros")
    println("Has three zeros: $hasThreeZeros")
}
