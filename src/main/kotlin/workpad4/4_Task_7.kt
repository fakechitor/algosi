package workpad4

import java.util.LinkedList

private class IntHashMap(private val size: Int) {

    private val map = Array<LinkedList<Int>>(size) { LinkedList() }

    private fun getHashKey(value: Int): Int {
        return value % size
    }

    fun put(value: Int) {
        val index = getHashKey(value)
        val bucket = map[index]

        if (!bucket.contains(value)) {
            bucket.add(value)
        }
    }

    override fun toString(): String {
        return "IntHashMap(size=$size, map=${map.contentToString()})"
    }
}

fun main() {
    val intHashMap = IntHashMap(7)
    val arrayOfNums = listOf(86, 90, 27, 29, 38, 30, 40)
    println(arrayOfNums.toString())
    for (item in arrayOfNums) {
        intHashMap.put(item)
    }
    println(intHashMap)
}
