package codility

class FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        var count = 0
        for (n in nums) {
            if (n > 0) ++count
        }
        run {
            var i = 0
            while (i < nums.size) {
                if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= count && nums[nums[i] - 1] != nums[i]
                ) {
                    swap(nums, i, nums[i] - 1)
                    --i
                }
                ++i
            }
        }
        for (i in 1..count) {
            if (nums[i - 1] != i) {
                return i
            }
        }
        return 1 + count
    }

    fun swap(a: IntArray, i: Int, j: Int) {
        val t = a[i]
        a[i] = a[j]
        a[j] = t
    }
}