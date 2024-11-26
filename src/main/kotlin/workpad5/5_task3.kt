package workpad5

fun insertionSort(arr: IntArray) {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}

fun main() {
    println("insertion sort")
    val array = intArrayOf(228, 34, 25, -121, 322, 11, 0)
    println("array: ${array.toList()}")
    insertionSort(array)
    println("sorted: ${array.toList()}")
}
