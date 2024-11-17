package workpad2

fun main() {
    generateRandomNums(14563, 10)
}
private fun generateRandomNums(startNum : Int, amountOfNums : Int){
    var newNum = startNum
    for (i in 0..amountOfNums){
        val temp = (newNum * newNum).toString().substring(2..6)
        println(temp)
        newNum = temp.toInt()
    }
}
