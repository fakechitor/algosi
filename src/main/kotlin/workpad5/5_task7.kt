package workpad5

import kotlin.time.measureTime


private fun testSorts(smallArray : IntArray, bigArray : IntArray) {
    println("small array size = ${smallArray.size}")
    println("big array size = ${bigArray.size}")
    println()
    measureBubbleSort(smallArray, bigArray)
    measureShakerSort(smallArray, bigArray)
    measureInsertionSort(smallArray, bigArray)
    measureSelectionSort(smallArray, bigArray)
    measureShellSort(smallArray, bigArray)
    measureQuickSort(smallArray, bigArray)

}

private fun measureBubbleSort(smallArray: IntArray, bigArray : IntArray) {
    println("Bubble sort:")
    val timeSmallArray = measureTime {
        bubbleSort(smallArray)
    }
    println("small array: $timeSmallArray")
    val timeBigArray = measureTime {
        bubbleSort(bigArray)
    }
    println("big array; $timeBigArray")
    println()
}

private fun measureShakerSort(smallArray: IntArray, bigArray : IntArray) {
    println("Shaker sort:")
    val timeSmallArray = measureTime {
        shakerSort(smallArray)
    }
    println("small array: $timeSmallArray")
    val timeBigArray = measureTime {
        shakerSort(bigArray)
    }
    println("big array; $timeBigArray")
    println()
}

private fun measureInsertionSort(smallArray: IntArray, bigArray : IntArray) {
    println("Insertion sort:")
    val timeSmallArray = measureTime {
        insertionSort(smallArray)
    }
    println("small array: $timeSmallArray")
    val timeBigArray = measureTime {
        insertionSort(bigArray)
    }
    println("big array; $timeBigArray")
    println()
}

private fun measureSelectionSort(smallArray: IntArray, bigArray : IntArray) {
    println("Selection sort:")
    val timeSmallArray = measureTime {
        selectionSort(smallArray)
    }
    println("small array: $timeSmallArray")
    val timeBigArray = measureTime {
        selectionSort(bigArray)
    }
    println("big array; $timeBigArray")
    println()
}

private fun measureShellSort(smallArray: IntArray, bigArray : IntArray) {
    println("Shell sort:")
    val timeSmallArray = measureTime {
        shellSort(smallArray)
    }
    println("small array: $timeSmallArray")
    val timeBigArray = measureTime {
        shellSort(bigArray)
    }
    println("big array; $timeBigArray")
    println()
}

private fun measureQuickSort(smallArray: IntArray, bigArray : IntArray) {
    println("Quick sort:")
    println(bigArray.size)
    val timeSmallArray = measureTime {
        quickSort(smallArray, 0, smallArray.size-1)
    }
    println("small array: $timeSmallArray")
    val timeBigArray = measureTime {
        quickSort(bigArray, 0, bigArray.size-1)
    }
    println("big array; $timeBigArray")
    println()
}

fun main() {
    val smallArray = intArrayOf(228, 34, 25, -121, 322, 11, 0)
    var bigArray = IntArray(20001) { it - 10000 }
    bigArray = bigArray.toList().shuffled().toIntArray()
    testSorts(smallArray, bigArray)
}