package leetcode_study_badge.data_structure

class Day20 {
    fun findKthLargest(nums: IntArray, k: Int) = nums.sortedDescending()[k - 1]
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEach { map[it] = map.getOrDefault(it, 0) + 1 }

        val uniques = mutableListOf<Int>()
        val pairs = map.toList().sortedByDescending { it.second }
        pairs.forEach {
            while (uniques.size < k) {
                uniques.add(it.first)
                break
            }
        }

        return uniques.toIntArray()
    }
}