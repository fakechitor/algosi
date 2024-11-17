package workpad4

import kotlin.math.*

const val EPSILON = 0.0001

fun calculateFunc(x: Double): Double {
    return sqrt(1 - 0.4 * x.pow(2)) - asin(x)
}

fun f(L: Double, R: Double): Double {
    val B = (L + R) / 2.0

    if (abs(R - L) <= EPSILON) {
        println("x = $B")
        println("f(B) = ${calculateFunc(B)}")
        return B
    }

    return if (calculateFunc(L) * calculateFunc(B) < 0) {
        f(L, B)
    } else {
        f(B, R)
    }
}
fun printDiv(){
//    val answer = f(B)
}


fun main() {
    val L = 0.0
    val R = 1.0
    f(L, R)
}