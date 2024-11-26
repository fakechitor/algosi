package workpad5

fun quickSort(arr: IntArray, left: Int = 0, right: Int = arr.size - 1): IntArray {
    var start = left
    var end = right
    val pivot = arr[(left + right) / 2]

    while (start <= end) {
        while (arr[start] < pivot) {
            start++
        }
        while (arr[end] > pivot) {
            end--
        }
        if (start <= end) {
            val temp = arr[start]
            arr[start] = arr[end]
            arr[end] = temp
            start++
            end--
        }
    }

    if (left < end) {
        quickSort(arr, left, end)
    }
    if (start < right) {
        quickSort(arr, start, right)
    }
    return arr
}


fun main() {
    println("quick sort")
    val array = intArrayOf(228, 34, 25, -121, 322, 11, 0)
    println("array: ${array.toList()}")
    quickSort(array, 0, array.size - 1)
    println("sorted: ${array.toList()}")
}
