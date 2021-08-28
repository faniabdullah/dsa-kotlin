package compotitiveProgramming.mockup

class FindOccurost {
    fun solution(nums: IntArray, target: Int) {
        var firsOccident = -1
        var lastOccident = -1
        for (i in nums.indices) {
            if (nums[i] == target && firsOccident == -1) {
                firsOccident = i
                lastOccident = i
            } else if (firsOccident != -1 && nums[i] == target) {
                lastOccident = i
            }
        }
        println(firsOccident)
        println(lastOccident)
    }

    fun solutionBNS(nums1: IntArray, target: Int): IntArray {

        var first: Int = Int.MAX_VALUE
        var last: Int = -1
        var low = 0
        var size = nums1.size - 1
        while (low < size) {
            val mid: Int = (low + size) / 2
            if (nums1[mid] == target && nums1[mid + 1] == target) {
                first = minOf(mid, first)
                last = maxOf(mid, last)
                size -= 1
            } else if (nums1[mid] == target) {
                first = minOf(mid, first)
                last = maxOf(mid, last)
                size = mid
            } else if (nums1[mid] > target) {
                low = mid + 1
            } else {
                size = mid
            }
            println(low)
            println(size)
        }
        return intArrayOf(first, last)
    }
}

fun main() {
    val result = FindOccurost().solutionBNS(intArrayOf(1, 2, 2, 2, 2, 3, 4, 7, 8, 8), 2)
    println(result.contentToString())
}