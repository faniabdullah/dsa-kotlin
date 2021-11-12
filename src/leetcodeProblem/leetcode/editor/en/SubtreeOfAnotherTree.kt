//Given the roots of two binary trees root and subRoot, return true if there is
//a subtree of root with the same structure and node values of subRoot and false 
//otherwise. 
//
// A subtree of a binary tree tree is a tree that consists of a node in tree 
//and all of this node's descendants. The tree tree could also be considered as a 
//subtree of itself. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,4,5,1,2], subRoot = [4,1,2]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the root tree is in the range [1, 2000]. 
// The number of nodes in the subRoot tree is in the range [1, 1000]. 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
// Related Topics Tree Depth-First Search String Matching Binary Tree Hash 
//Function 👍 4336 👎 205


package leetcodeProblem.leetcode.editor.en

import data_structure.tree.TreeNode

class SubtreeOfAnotherTree {
    fun solution() {
    }
    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.value
     * Definition for a binary tree node.
     * class TreeNode(var value: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.value
     * Definition for a binary tree node.
     * class TreeNode(var value: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = null
     * }
     */
    class Solution {
        private var result = false
        fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {

            fun check(n1: TreeNode?, n2: TreeNode?): Boolean {
                if (n1 == null && n2 == null) return true else if (n1 == null || n2 == null) return false
                return if (n1.value == n2.value) check(n1.left, n2.left) && check(n1.right, n2.right) else false
            }

            fun dfs(t1: TreeNode?, t2: TreeNode?) {
                if (t1 == null) return
                dfs(t1.left, t2)
                if (t1?.value == t2?.value) {
                    result = result || check(t1, t2)
                    if (result) return
                }
                dfs(t1.right, t2)
            }

            dfs(root, subRoot)

            return result
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  

