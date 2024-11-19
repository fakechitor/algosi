package workpad4

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

fun main() {
    val jsonData = File("src/main/kotlin/resources/data.json")
    val mapper = jacksonObjectMapper()

    val users: List<Map<String, Any>> = mapper.readValue(jsonData)

    val userMap: Map<Int, String> = users.associate {
        it["id"] as Int to it["name"] as String
    }
    println(userMap)
}
