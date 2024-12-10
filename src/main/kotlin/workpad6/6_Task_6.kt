package workpad6

class Node(var value: Int) {
    var nextNode: Node? = null
}

class LinkedList {
    var headNode: Node? = null

    fun isEmpty(): Boolean {
        return headNode == null
    }

    fun addAtBeginning(value: Int) {
        val newNode = Node(value)
        newNode.nextNode = headNode
        headNode = newNode
    }

    fun addAtEnd(value: Int) {
        val newNode = Node(value)
        if (headNode == null) {
            headNode = newNode
        } else {
            var temp = headNode
            while (temp?.nextNode != null) {
                temp = temp.nextNode
            }
            temp?.nextNode = newNode
        }
    }

    fun addAfterN(value: Int, n: Int) {
        var temp = headNode
        var count = 1
        while (temp != null && count < n) {
            temp = temp.nextNode
            count++
        }
        if (temp != null) {
            val newNode = Node(value)
            newNode.nextNode = temp.nextNode
            temp.nextNode = newNode
        }
    }

    fun count(): Int {
        var temp = headNode
        var size = 0
        while (temp != null) {
            size++
            temp = temp.nextNode
        }
        return size
    }

    fun tailList(): LinkedList {
        val newList = LinkedList()
        val head = headNode ?: return newList
        if (head.nextNode == null) return newList

        var temp = head.nextNode
        while (temp != null) {
            newList.addAtEnd(temp.value)
            temp = temp.nextNode
        }
        return newList
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var temp = headNode
        while (temp != null) {
            sb.append(temp.value)
            if (temp.nextNode != null) sb.append(" -> ")
            temp = temp.nextNode
        }
        return sb.toString()
    }
}

fun main() {
    val list = LinkedList()
    list.addAtEnd(10)
    list.addAtEnd(20)
    list.addAtEnd(30)
    list.addAtBeginning(5)
    list.addAfterN(15, 2)
    println("linked list: $list")
    println("empty: ${list.isEmpty()}")
    println("count: ${list.count()}")
    val tail = list.tailList()
    println("tail list: $tail")
}
