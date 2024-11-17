package workpad3

fun getSumOfTwoNums (num1 : List<Int>, num2 : List<Int> ) : MutableList<Int> {
    val answer : MutableList<Int> = mutableListOf()
    TODO()
}

fun longDivision(str1 : String, str2 : String) : Int {
    val int1 = str1.toMutableList().map{it.digitToInt()}.reversed()
    val int2 = str2.toMutableList().map{it.digitToInt()}.reversed()
    getSumOfTwoNums(int1,int2)
    TODO()
}

fun main() {
    longDivision("189", "123")
}
