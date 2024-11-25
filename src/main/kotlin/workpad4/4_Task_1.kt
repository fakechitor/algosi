package workpad4

fun getGcd(a : Int, b : Int) : Int {
    return when {
        a==0 -> b
        b==0 -> a
        a==b -> a
        a > b -> getGcd(a-b,b)
        else -> getGcd(a,b-a)
    }
}
fun printGcd(a : Int, b : Int){
    if (a == 0 && b==0){
        println("$a $b gcd: Error")
    }
    else { println("$a $b gcd: ${getGcd(a, b)}") }
}

fun main() {
    printGcd(1, 0)
    printGcd(0, 4)
    printGcd(0, 0)
    printGcd(8, 64)
}
