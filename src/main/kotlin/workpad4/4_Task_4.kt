package workpad4

import kotlin.math.abs

private fun getDigitsSum(num : Int,sum : Int) : Int {
    if (num % 10 == 0) {
        return sum
    }
    return getDigitsSum(num/10, sum+num%10)
}

private fun printSumOfDigits(num: Int){
    println("$num sum: ${getDigitsSum(abs(num), 0)}")
}

fun main() {
    printSumOfDigits(1234)
    printSumOfDigits(-1234)
    printSumOfDigits(0)
}