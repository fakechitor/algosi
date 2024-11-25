package workpad5


fun bubbleSort(arr: IntArray) {
    val n = arr.size
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
}

fun main() {
    val array = intArrayOf(228, 34, 25, -121, 322, 11, 0)
    println("array: ${array.toList()}}")
    bubbleSort(array)
    println("sorted: ${array.toList()}")
}
