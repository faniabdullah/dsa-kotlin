package leetcode_study_badge.data_structure

import data_structure.tree.TreeNode
import data_structure.tree.TreeTraversal


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

    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
    var preorderIndex = 0
    private var inorderIndexMap: HashMap<Int, Int> = HashMap()
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        preorderIndex = 0

        inorderIndexMap = HashMap()
        for (i in inorder.indices) {
            inorderIndexMap[inorder[i]] = i
        }
        return arrayToTree(preorder, 0, preorder.size - 1)
    }

    private fun arrayToTree(preorder: IntArray, left: Int, right: Int): TreeNode? {

        if (left > right) return null

        val rootValue = preorder[preorderIndex++]
        val root = TreeNode(rootValue)


        root.left = arrayToTree(preorder, left, inorderIndexMap[rootValue]!! - 1)
        root.right = arrayToTree(preorder, inorderIndexMap[rootValue]!! + 1, right)
        return root
    }


}

fun main() {
    val result = Day15().sortedArrayToBST(intArrayOf(1, 2, 3, 4, 5, 6))
    println(TreeTraversal().printLevelOrder(result))
}