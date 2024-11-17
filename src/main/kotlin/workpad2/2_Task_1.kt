package main.kotlin.workpad2
import kotlin.math.abs
var k = 0
private fun methodSubs(nums : List<Int>) : Int {
    val newNums :MutableList<Int> = nums.sortedDescending().toMutableList();
    if (newNums.size ==0) return 0
    while(newNums.size > 1) {
        val newElem = nodeMin(newNums.first(), newNums.last());
        newNums.remove(newNums.first())
        newNums.remove(newNums.last())
        newNums.add(newElem)
    }
    return newNums.first()
}
private fun nodeMin(firstNum : Int, secondNum : Int) : Int{
    var diff = 0
    var first = firstNum
    var second = secondNum
    var flag = false
    while (!flag) {
        if (first == second) {
            flag = true
        }
        else if (first < second) {
            diff = second - first
            second = first
            first = diff
        }
        else{
            diff = first - second
            first = second
            second = diff
        }
    }
    return diff
}
private fun getGCD(nums : List<Int>){
    k++
    val listOfEnteredNums = getListOfPositiveNumbers(nums.toMutableList())
    val divider = methodSubs(listOfEnteredNums)
    println("Test $k. List: $nums. Div: $divider")
}
private fun getListOfPositiveNumbers(listOfNums : MutableList<Int>) : List<Int> {
    var newList = listOfNums.filter { it != 0 }
    newList = newList.map { abs(it) }.toMutableList()
    return newList
}
fun main() {
    getGCD(listOf(-8,0,32,64))
    getGCD(listOf(1,7,11,17))
    getGCD(listOf(0,0,0,0))
}
