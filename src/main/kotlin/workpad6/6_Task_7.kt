package workpad6

fun listsAreEqual(L1: LinkedList, L2: LinkedList): Boolean {
    var t1 = L1.headNode
    var t2 = L2.headNode
    while (t1 != null && t2 != null) {
        if (t1.value != t2.value) return false
        t1 = t1.nextNode
        t2 = t2.nextNode
    }
    return t1 == null && t2 == null
}

fun allElementsOfL1InL2(L1: LinkedList, L2: LinkedList): Boolean {
    var t1 = L1.headNode
    while (t1 != null) {
        if (!contains(L2, t1.value)) return false
        t1 = t1.nextNode
    }
    return true
}

fun contains(L: LinkedList, value: Int): Boolean {
    var temp = L.headNode
    while (temp != null) {
        if (temp.value == value) return true
        temp = temp.nextNode
    }
    return false
}

fun hasDuplicate(L: LinkedList): Boolean {
    val seen = HashSet<Int>()
    var temp = L.headNode
    while (temp != null) {
        if (!seen.add(temp.value)) return true
        temp = temp.nextNode
    }
    return false
}

fun moveFirstToLast(L: LinkedList) {
    val head = L.headNode ?: return
    if (head.nextNode == null) return
    L.headNode = head.nextNode
    head.nextNode = null
    var temp = L.headNode
    while (temp?.nextNode != null) {
        temp = temp.nextNode
    }
    temp?.nextNode = head
}

fun moveLastToFirst(L: LinkedList) {
    if (L.headNode == null || L.headNode?.nextNode == null) return
    var prev: Node? = null
    var curr = L.headNode
    while (curr?.nextNode != null) {
        prev = curr
        curr = curr.nextNode
    }
    prev?.nextNode = null
    curr?.nextNode = L.headNode
    L.headNode = curr
}

fun appendL2ToL1(L1: LinkedList, L2: LinkedList) {
    var temp = L2.headNode
    while (temp != null) {
        L1.addAtEnd(temp.value)
        temp = temp.nextNode
    }
}

fun reverse(L: LinkedList) {
    var prev: Node? = null
    var curr = L.headNode
    while (curr != null) {
        val next = curr.nextNode
        curr.nextNode = prev
        prev = curr
        curr = next
    }
    L.headNode = prev
}

fun leaveFirstOccurrences(L: LinkedList) {
    val seen = HashSet<Int>()
    var temp = L.headNode
    var prev: Node? = null
    while (temp != null) {
        if (!seen.add(temp.value)) {
            prev?.nextNode = temp.nextNode
        } else {
            prev = temp
        }
        temp = temp.nextNode
    }
}

fun main() {
    val L1 = LinkedList()
    L1.addAtEnd(1)
    L1.addAtEnd(2)
    L1.addAtEnd(3)
    L1.addAtEnd(2)
    L1.addAtEnd(4)

    val L2 = LinkedList()
    L2.addAtEnd(1)
    L2.addAtEnd(2)
    L2.addAtEnd(3)
    L2.addAtEnd(4)
    L2.addAtEnd(5)

    println("L1: $L1")
    println("L2: $L2")
    println("a) lists equal: ${listsAreEqual(L1, L2)}")
    println("б) all elements of L1 in L2: ${allElementsOfL1InL2(L1, L2)}")
    println("в) L1 has duplicate: ${hasDuplicate(L1)}")

    moveFirstToLast(L1)
    println("г) move first to last L1: $L1")

    moveLastToFirst(L1)
    println("д) move last to first L1: $L1")

    appendL2ToL1(L1, L2)
    println("е) append L2 to L1: $L1")

    reverse(L1)
    println("ж) reverse L1: $L1")

    leaveFirstOccurrences(L1)
    println("з) leave first occurrences L1: $L1")
}