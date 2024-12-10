package workpad6

fun printDescending(arr : List<Double>) {
    println(arr.joinToString(separator = " "))
    val isDescending = (0 until arr.size - 1).all { arr[it] >= arr[it + 1] }
    println(isDescending)
}

fun main() {
    var arr = doubleArrayOf(10.0, 9.5, 9.5, 8.2, 7.1, 7.1, 5.0).toList()
    printDescending(arr)
    arr = doubleArrayOf(10.0, 9.5, 9.5, 8.2, 7.1, 7.1, 5.0, 1213.0).toList()
    printDescending(arr)
}