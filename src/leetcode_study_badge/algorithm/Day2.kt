package leetcode_study_badge.algorithm

class Day2 {
    fun sortedSquares(nums: IntArray): IntArray {
        var right = nums.size - 1
        var left = 0
        val resultArray = IntArray(nums.size)
        var insertPosition = nums.size - 1

        while (left < right) {
            val leftValue = nums[left] * nums[left]
            val rightValue = nums[right] * nums[right]
            if (leftValue > rightValue) {
                resultArray[insertPosition] = leftValue
                insertPosition--
                left++
            } else if (rightValue > leftValue) {
                resultArray[insertPosition] = rightValue
                insertPosition--
                right--
            } else if (rightValue == leftValue) {
                resultArray[insertPosition] = rightValue
                insertPosition--
                resultArray[insertPosition] = leftValue
                insertPosition--
                right--
                left++
            }
        }
        println(resultArray.contentToString())
        if (left == right) {
            resultArray[insertPosition] = nums[left] * nums[left]
        }

        return resultArray
    }

    fun rotate(nums: IntArray, k: Int) {
        for (i in 0 until k) {
            var temp = nums[0]
            nums[0] = nums[nums.size - 1]
            for (a in 1 until nums.size) {
                var swap = nums[a]
                nums[a] = temp
                temp = swap
            }
        }
    }

    fun rotateTwoPointer(nums: IntArray, k: Int) {

        fun reverse(i: Int, j: Int) {
            var i = i; var j = j

            while (i < j) {
                nums[i] = nums[j].also { nums[j] = nums[i] }
                i++; j--
            }
        }

        val N = nums.size
        val k = k % N

        reverse(0, N - 1)
        reverse(0, k - 1)
        reverse(k, N - 1)
    }



}

fun main() {
    println(Day2().sortedSquares(intArrayOf(-7, -3, 2, 3, 11)).contentToString())
    val rotateArray = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    println(rotateArray.contentToString())
    Day2().rotateTwoPointer(rotateArray, 3)
    println(rotateArray.contentToString())
}