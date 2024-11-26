package workpad5

fun selectionSort(arr: IntArray) {
    for (i in arr.indices) {
        var minIndex = i
        for (j in i + 1 until arr.size) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j
            }
        }
        val temp = arr[minIndex]
        arr[minIndex] = arr[i]
        arr[i] = temp
    }
}

fun main() {
    println("selection sort")
    val array = intArrayOf(228, 34, 25, -121, 322, 11, 0)
    println("array: ${array.toList()}")
    selectionSort(array)
    println("sorted: ${array.toList()}")
}
