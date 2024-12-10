package workpad6

fun main() {
    val list = mutableListOf(1, 2, 3, 4, 5, 6)
    val n = 2

    println("list: $list")
    cyclicShift(list, n)
    println("list after moving on $n elements: $list")
}

fun cyclicShift(list: MutableList<Int>, n: Int) {
    val size = list.size
    if (size == 0) return
    val shift = ((n % size) + size) % size
    if (shift == 0) return
    val rotated = list.takeLast(shift) + list.dropLast(shift)
    list.clear()
    list.addAll(rotated)
}
