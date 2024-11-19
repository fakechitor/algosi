package workpad4

fun main() {
    val map = CustomHashMap<String, Int>()
    map.put("Petrov", 891999999)
    println(map.toString())
    println(map.get("Petrov"))
    println(map.toString())
    map.remove("Petrov", 891999999)
    println(map.toString())
    println(map.get("Petrov"))
}