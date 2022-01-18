//Given the root of a binary tree, return the inorder traversal of its nodes'
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,3,2]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [2,1]
// 
//
// Example 5: 
//
// 
//Input: root = [1,null,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively? 
//Related Topics Stack Tree Depth-First Search Binary Tree 👍 6150 👎 259


package leetcodeProblem.leetcode.editor.en

import data_structure.tree.TreeNode
import java.util.*


class BinaryTreeInorderTraversal {
    fun solution() {
    }
    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class TreeNode(var `val`: Int) {
     *     var left: TreeNode? = null
     *     var right: TreeNode? = nullg
     * }
     */
    class Solution {
        private val listInOrder = mutableListOf<Int>()
        fun inorderTraversal(root: TreeNode?): List<Int> {

            fun recursive(r1: TreeNode?) {
                if (r1 == null) return
                if (r1.left != null) {
                    recursive(r1.left)
                }
                listInOrder.add(r1.value)
                if (r1.right != null) {
                    recursive(r1.right)
                }
            }

            fun iterative(r2: TreeNode?) {
                val stack = Stack<TreeNode>()
                var curr = r2
                while (curr != null || !stack.isEmpty()) {
                    while (curr != null) {
                        stack.push(curr)
                        curr = curr.left
                    }
                    curr = stack.pop()
                    listInOrder.add(curr.value)
                    curr = curr.right
                }
            }

            iterative(root)

            return listInOrder
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  

