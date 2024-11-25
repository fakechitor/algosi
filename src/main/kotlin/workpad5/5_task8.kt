package workpad5

import kotlin.system.measureTimeMillis

fun binarySearch(arr: IntArray, low: Int, high: Int, key: Int): Int {
    var left = low
    var right = high
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (arr[mid] == key) {
            return mid
        }
        if (arr[mid] < key) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return left
}

fun insertionSortWithBinarySearch(arr: IntArray) {
    for (i in 1 until arr.size) {
        val key = arr[i]
        val position = binarySearch(arr, 0, i - 1, key)
        for (j in i downTo position + 1) {
            arr[j] = arr[j - 1]
        }

        arr[position] = key
    }
}

fun measureExecutionTime(array: IntArray, sortFunction: (IntArray) -> Unit): Long {
    return measureTimeMillis {
        sortFunction(array.copyOf())
    }
}

fun main() {
    val smallArray = IntArray(100) { (0..1000).random() }
    val bigArray = IntArray(10000) { (0..10000).random() }

    val smallArrayTimeInsertionSort = measureExecutionTime(smallArray) { insertionSort(it) }
    val bigArrayTimeInsertionSort = measureExecutionTime(bigArray) { insertionSort(it) }

    val smallArrayTimeBinarySort = measureExecutionTime(smallArray) { insertionSortWithBinarySearch(it) }
    val bigArrayTimeBinarySort = measureExecutionTime(bigArray) { insertionSortWithBinarySearch(it) }

    println("insertion sort")
    println("small array: $smallArrayTimeInsertionSort ms")
    println("big array: $bigArrayTimeInsertionSort ms")

    println("binary insertion sort")
    println("small array: $smallArrayTimeBinarySort ms")
    println("big array: $bigArrayTimeBinarySort ms")
}
