import kotlin.random.Random
import kotlin.system.measureTimeMillis

private fun insertionSortClassic(array: IntArray) {
    for (i in 1 until array.size) {
        val key = array[i]
        var j = i - 1
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = key
    }
}
private fun binarySearchPosition(array: IntArray, left: Int, right: Int, key: Int): Int {
    var low = left
    var high = right
    while (low < high) {
        val mid = (low + high) / 2
        if (array[mid] > key) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}
fun insertionSortBinary(array: IntArray) {
    for (i in 1 until array.size) {
        val key = array[i]
        val pos = binarySearchPosition(array, 0, i, key)
        for (j in i downTo pos + 1) {
            array[j] = array[j - 1]
        }
        array[pos] = key
    }
}
fun main() {
    val size = 100_000
    println("size: $size")
    val arrayClassic = IntArray(size) { Random.nextInt(0, 10_000) }
    val arrayBinary = arrayClassic.copyOf()

    val timeClassic = measureTimeMillis {
        insertionSortClassic(arrayClassic)
    }
    val timeBinary = measureTimeMillis {
        insertionSortBinary(arrayBinary)
    }
    println("insertion sort: $timeClassic мс")
    println("binary insertion sort: $timeBinary мс")
}
