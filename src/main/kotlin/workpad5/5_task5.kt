package workpad5

fun shellSort(arr: IntArray) {
    var gap = arr.size / 2
    while (gap > 0) {
        for (i in gap until arr.size) {
            val temp = arr[i]
            var j = i
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap]
                j -= gap
            }
            arr[j] = temp
        }
        gap /= 2
    }
}

fun main() {
    val array = intArrayOf(228, 34, 25, -121, 322, 11, 0)
    println("array: ${array.toList()}")
    shellSort(array)
    println("sorted: ${array.toList()}")
}
