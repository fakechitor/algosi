package workpad4

fun twoSum(nums: IntArray, target: Int): IntArray? {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    return null
}

fun main() {
    val nums = intArrayOf(-1, 2, 3, 4, 7)
    println("array: ${nums.asList()}")
    val target = 5
    println("required sum $target")
    val result = twoSum(nums, target)
    if (result != null) {
        println("indexes: ${result[0]}, ${result[1]}")
    } else {
        println("no pair")
    }
}
