package leetcode_study_badge.data_structure

import java.util.*


class Day2 {
    fun sortColors(nums: IntArray) {
        var one = 0
        var two = 0
        var insertPosition = -1

        repeat(nums.count()) {
            if (nums[it] == 0) {
                insertPosition++
                nums[insertPosition] = 0
            } else if (nums[it] == 1) {
                one++
            } else {
                two++
            }
        }

        repeat(one) {
            insertPosition++
            nums[insertPosition] = 1
        }
        repeat(two) {
            insertPosition++
            nums[insertPosition] = 2
        }

    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        Arrays.sort(
            intervals
        ) { a: IntArray, b: IntArray -> a[0].compareTo(b[0]) }
        val merged = mutableListOf<IntArray>()
        // [0, 3][0, 1][0, 2][1, 9][2, 5][10, 11][12, 20][19, 20]
        for (interval in intervals) {
            println(interval.contentToString())
            if (merged.isEmpty() || merged.last()[1] < interval[0]) {
                merged.add(interval)
            } else {
                merged.last()[1] = maxOf(merged.last()[1], interval[1])
            }
        }
        return merged.toTypedArray()
    }
}


class MyHashMap() {
    /** Initialize your data structure here. */
    private val data = arrayOfNulls<Int>(1000001)

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        data[key] = value
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        return data[key] ?: -1
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        data[key] = null
    }

}

fun main() {
    val intArray = intArrayOf(2, 0, 2, 1, 1, 0)
    Day2().sortColors(intArray)
    val intArrayIntervals = arrayOf(
        intArrayOf(1, 4),
        intArrayOf(0, 4)
    )
    val result = Day2().merge(intArrayIntervals)
    result.forEach {
        print(it.contentToString())
    }
    println(intArray.contentToString())
}
