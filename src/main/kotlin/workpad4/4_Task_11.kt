package workpad4

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

fun main() {
    val jsonData = File("src/main/kotlin/resources/data.json")
    val mapper = jacksonObjectMapper()

    val users: List<Map<String, Any>> = mapper.readValue(jsonData)

    val userMap: HashMap<Int, MutableList<String>> = HashMap()

    users.forEach {
        val id = it["id"] as Int
        val name = it["name"] as String
        userMap.computeIfAbsent(id) { mutableListOf() }.add(name)
    }

    println(userMap)
}
