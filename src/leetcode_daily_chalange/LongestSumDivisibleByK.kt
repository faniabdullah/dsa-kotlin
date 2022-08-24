package leetcode_daily_chalange

// https://leetcode.com/problems/subarray-sums-divisible-by-k/

fun subArraysDivByK(nums: IntArray, k: Int): Int {
    if (nums.isEmpty()) return 0
    val mutableMap = mutableMapOf<Int, Int>()
    var prefixSum = 0
    var ans = 0
    mutableMap[0] = 0
    for (i in nums.indices) {
        prefixSum += nums[i]
        var util = prefixSum % k
        if (util < 0) {
            util += k
        }
        if (mutableMap[util] != null) {
            ans += mutableMap[util]!! + 1
            mutableMap[util] = mutableMap[util]!! + 1
        } else mutableMap[util] = 0
    }

    return ans

}
