package leetcode_daily_chalange

import data_structure.tree.TreeNode

class DiameterOfBinaryTree {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        var ans = 0
        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0
            val l = dfs(root.left)
            val r = dfs(root.right)
            ans = maxOf(ans, l + r)
            return maxOf(l, r) + 1
        }
        dfs(root)
        return ans
    }
}