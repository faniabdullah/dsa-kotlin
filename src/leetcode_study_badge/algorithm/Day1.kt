package leetcode_study_badge.algorithm

class Day1 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        if (nums[right] == target) return right
        if (nums[right] < target) return right + 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) return mid
            if (nums[mid] < target && nums[mid + 1] > target) return mid + 1
            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return 0
    }
    /* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */


    fun firstBadVersion(n: Int): Int {
        return firstBadHelp(n, 0, n - 1)
    }

    private fun firstBadHelp(value: Int, first: Int, last: Int): Int {
        val mid = first + (last - first) / 2
        if (isBadVersion(last) && !isBadVersion(last - 1)) {
            return last
        }

        if (isBadVersion(mid)) {
            return firstBadHelp(value, first, mid)
        } else {
            return firstBadHelp(value, mid + 1, last)
        }
    }

    private fun isBadVersion(bad: Int): Boolean {
        val badReally = 5
        return badReally == bad
    }

    fun search(nums: IntArray, target: Int): Int {
        return binarySearch(nums, 0, nums.size - 1, target)

    }

    private fun binarySearch(
        intArray: IntArray, first: Int,
        last: Int, target: Int
    ): Int {
        if (last >= first) {
            val mid: Int = first + (last - first) / 2
            if (intArray[mid] == target) return mid
            if (intArray[mid] > target) return binarySearch(intArray, first, mid - 1, target)
            return binarySearch(intArray, mid + 1, last, target)
        }

        return -1
    }

}