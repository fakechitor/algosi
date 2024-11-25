package workpad4

fun main() {
    val map = CustomHashMap<String, Int>()
    map.put("Petrov", 891999999)
    println("Добавление элемента:")
    println(map.toString())
    println()
    println("Получение элемента по ключу:")
    println(map.get("Petrov"))
    println()
    println("Удаление элемента:")
    map.remove("Petrov", 891999999)
    println(map.toString())
    println()
    println("Получение несуществующего элемента:")
    println(map.get("Petrov"))
}