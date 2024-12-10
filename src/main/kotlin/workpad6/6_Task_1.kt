package workpad6

import kotlin.math.sqrt

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 16, 18, 24, 7, 15, 27)
    val n = arr.size
    fun factorial(k: Int): Long {
        var res = 1L
        for (x in 1..k) res *= x
        return res
    }
    fun twoPower(k: Int): Long {
        return 1L shl k
    }
    val countOdd = arr.count { it % 2 != 0 }
    val countEvenSquare = arr.count {
        val r = sqrt(it.toDouble())
        r == r.toInt().toDouble() && (r.toInt() % 2 == 0)
    }
    val countDiv3Not5 = arr.count { (it % 3 == 0) && (it % 5 != 0) }
    val countConditionG = arr.withIndex().count { (i, value) ->
        val k = i + 1
        twoPower(k) < value && value < factorial(k)
    }
    val countConditionD = (1 until n - 1).count { i ->
        arr[i] < (arr[i - 1] + arr[i + 1]) / 2.0
    }
    val countEvenIndexOddValue = arr.withIndex().count { (i, value) ->
        i % 2 == 1 && value % 2 != 0
    }
    println("[${arr.joinToString(" ")}]")
    println("a) $countOdd")
    println("б) $countEvenSquare")
    println("в) $countDiv3Not5")
    println("г) $countConditionG")
    println("д) $countConditionD")
    println("е) $countEvenIndexOddValue")
}