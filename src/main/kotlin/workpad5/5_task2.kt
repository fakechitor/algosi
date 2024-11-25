package workpad5

fun shakerSort(arr: IntArray) {
    var left = 0
    var right = arr.size - 1
    while (left < right) {
        for (i in left until right) {
            if (arr[i] > arr[i + 1]) {
                val temp = arr[i]
                arr[i] = arr[i + 1]
                arr[i + 1] = temp
            }
        }
        right--
        for (i in right downTo left + 1) {
            if (arr[i] < arr[i - 1]) {
                val temp = arr[i]
                arr[i] = arr[i - 1]
                arr[i - 1] = temp
            }
        }
        left++
    }
}

fun main() {
    val array = intArrayOf(228, 34, 25, -121, 322, 11, 0)
    println("array: ${array.toList()}")
    shakerSort(array)
    println("sorted: ${array.toList()}")
}
