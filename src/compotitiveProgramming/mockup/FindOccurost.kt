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
}

fun main() {
    FindOccurost().solution(intArrayOf( 1, 2, 2, 2, 2, 3, 4, 7, 8, 8), 8)
}