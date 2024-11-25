package workpad4

import java.util.LinkedList
import kotlin.math.absoluteValue

class CustomHashMap<K, V>(private val size: Int = 16) {
    private val buckets: Array<LinkedList<Pair<K, V>>> = Array(size) { LinkedList() }

    private fun getBucketIndex(key: K): Int {
        return key.hashCode().absoluteValue % size
    }
    fun put(key: K, value: V) {
        val bucketIndex = getBucketIndex(key)
        val bucket = buckets[bucketIndex]
        if (bucket.none { it.first == key && it.second == value }) {
            bucket.add(Pair(key, value))
        }
    }
    fun get(key: K): List<V> {
        val bucketIndex = getBucketIndex(key)
        val bucket = buckets[bucketIndex]
        return bucket.filter { it.first == key }.map { it.second }
    }
    fun remove(key: K, value: V): Boolean {
        val bucketIndex = getBucketIndex(key)
        val bucket = buckets[bucketIndex]
        val iterator = bucket.iterator()
        while (iterator.hasNext()) {
            val pair = iterator.next()
            if (pair.first == key && pair.second == value) {
                iterator.remove()
                return true
            }
        }
        return false
    }
    override fun toString(): String {
        return "HashTable(size=$size, buckets=${buckets.contentToString()})"
    }
}
