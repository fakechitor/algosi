package workpad6

private class CustomNode(var value: Int) {
    var nextNode: CustomNode? = null
}

private class CustomLinkedList {
    var headNode: CustomNode? = null

    fun append(element: Int) {
        val nodeToAdd = CustomNode(element)
        if (headNode == null) {
            headNode = nodeToAdd
        } else {
            var temp = headNode
            while (temp?.nextNode != null) {
                temp = temp.nextNode
            }
            temp?.nextNode = nodeToAdd
        }
    }
}

fun main() {
    val numbers = listOf(3, 5, 12, 15, 30)
    println(numbers.toString())
    val myList = CustomLinkedList()

    for (num in numbers) {
        myList.append(num)
    }

    var sum = 0
    var temp = myList.headNode
    while (temp != null) {
        sum += temp.value
        temp = temp.nextNode
    }

    println(sum)
}
