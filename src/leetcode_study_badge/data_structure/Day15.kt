package leetcode_study_badge.data_structure

import data_structure.tree.TreeNode
import data_structure.tree.TreeTravelsal


class Day15 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return partition(0, nums.size - 1, nums)
    }

    private fun partition(left: Int, right: Int, nums: IntArray): TreeNode? {
        val middle = left + (right - left) / 2
        if (left > right) return null
        val result: TreeNode? = TreeNode(nums[middle])
        result?.left = partition(left, middle - 1, nums)
        result?.right = partition(middle + 1, right, nums)
        return result
    }


}

fun main() {
    val result = Day15().sortedArrayToBST(intArrayOf(1, 2, 3, 4, 5, 6))
    println(TreeTravelsal().printLevelOrder(result))
}