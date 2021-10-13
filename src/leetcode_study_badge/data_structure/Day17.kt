package leetcode_study_badge.data_structure

import data_structure.tree.TreeNode

class Day17 {
    private var index = 0
    private var result = 0

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        helper(root, k)
        return result
    }

    private fun helper(node: TreeNode?, k: Int) {
        if (node == null) return

        helper(node.left, k)
        if (++index == k) {
            result = node.value
            return
        }
        helper(node.right, k)
    }

    class BSTIterator(root: TreeNode?) {
        val stack = ArrayDeque<TreeNode>()

        init {
            visitLeft(root)
        }

        private fun visitLeft(node: TreeNode?) {
            node?.run { stack.addLast(node) }
            node?.left?.run { visitLeft(node.left) }
        }

        fun next(): Int =
            stack.removeLast().let {
                visitLeft(it.right)
                it.value
            }

        fun hasNext(): Boolean =
            stack.isNotEmpty()

    }

}