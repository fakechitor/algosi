package workpad6

fun main() {
    val arr = intArrayOf(5, 10, 14, 20, 21, 25, 28, 30, 35, 40)
    val filtered = arr.filter { it % 5 == 0 && it % 7 != 0 }
    println(filtered.count())
    println(filtered.sum())
}
