package leetcode_daily_chalange


class FindAllDuplicatesInAnArray {
    // https://leetcode.com/problems/find-all-duplicates-in-an-array/
    fun findDuplicates(nums: IntArray): List<Int> {
        val mutableMap = mutableMapOf<Int, Int>()
        val mutableListOf = mutableListOf<Int>()
        nums.forEach {
            if (mutableMap[it] == null) {
                mutableMap[it] = mutableMap.getOrDefault(it, 0) + 1
            } else if (mutableMap[it] == 1) {
                mutableListOf.add(it)
            }
        }



        return mutableListOf
    }


}