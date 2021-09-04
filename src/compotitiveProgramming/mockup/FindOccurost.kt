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
        val first: Int = first(nums1, 0, nums1.size - 1, target)
        val last: Int = last(nums1, 0, nums1.size - 1, target)
        return intArrayOf(first, last)
    }

    private fun first(nums1: IntArray, low: Int, height: Int, target: Int): Int {
        if (height >= low) {
            val mid: Int = low + (height - low) / 2
            return when {
                nums1[mid] == target && nums1[mid - 1] != target -> {
                    return mid
                }
                target > nums1[mid] -> {
                    first(nums1, mid + 1, height, target)
                }
                else -> {
                    first(nums1, low, mid, target)
                }
            }
        }

        return -1
    }

    private fun last(nums1: IntArray, low: Int, height: Int, target: Int): Int {
        if (height >= low) {
            val mid: Int = low + (height - low) / 2
            if ((mid == nums1.size - 1 || target < nums1[mid + 1]) && nums1[mid] == target) {
                return mid
            } else if (nums1[mid] > target) {
                return last(nums1, low, mid - 1, target)
            } else {
                return last(nums1, mid + 1, height, target)
            }
        }

        return -1
    }
}

fun main() {
    val result = FindOccurost().solutionBNS(intArrayOf(1, 1, 9), 9)
    println(result.contentToString())
}