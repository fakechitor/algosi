package workpad6

fun getSolution(arr : IntArray) {
    println("[${arr.joinToString(" ")}]")
    val hasTwoZeros = (0 until arr.size - 1).any { arr[it] == 0 && arr[it + 1] == 0 }
    val hasThreeZeros = (0 until arr.size - 2).any { arr[it] == 0 && arr[it + 1] == 0 && arr[it + 2] == 0 }
    println("has two zeros: $hasTwoZeros")
    println("has three zeros: $hasThreeZeros")
}

fun main() {
    var arr = intArrayOf(1, 0, 0, 2, 0, 0, 3)
    getSolution(arr)
    arr = intArrayOf(1, 0, 0, 2, 0, 0, 0, 3)
    getSolution(arr)
}
