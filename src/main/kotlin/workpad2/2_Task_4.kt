package workpad2
import kotlin.math.pow
fun main() {
    testLL(8)
    testLL(2)
}
private fun testLL(p : Int){
    val M = 2.0.pow(p).toInt() -1
    if (isPrimeTest(p, M) || p == 2) {
        println("$p $M простое")
    } else {
        println("$p $M не простое")
    }
}
fun isPrimeTest(p: Int, m: Int): Boolean {
    var s = 4
    var k = 1
    while (k !=( p - 1)) {
        s = (s * s - 2) % m
        k++
    }
    if (s==0){
        return true
    }
    return false
}
