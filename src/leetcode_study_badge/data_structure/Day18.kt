package leetcode_study_badge.data_structure

import data_structure.tree.TreeNode
import java.util.*

class Day18 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root == p || root == q) return root

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        return when {
            left != null && right != null -> root
            left != null -> left
            else -> right
        }
    }

    fun serialize(root: TreeNode?): String {
        val q = LinkedList<TreeNode?>()
        q.offer(root)

        val res = StringBuilder()
        var lastPos = 0
        while (!q.isEmpty()) {
            val node = q.poll()
            if (node == null) {
                res.append("null")
            } else {
                res.append(node.value)
                lastPos = res.length
                q.offer(node.left)
                q.offer(node.right)
            }
            res.append(",")
        }
        return res.substring(0..lastPos - 1)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val list = data.split(",")
        val root = TreeNode(list[0].toInt())
        val q = ArrayDeque<TreeNode>()
        q.offer(root)

        var i = 1
        while (i < list.size && !q.isEmpty()) {
            val node = q.poll()
            if (i < list.size && list[i] != "null") {
                node.left = TreeNode(list[i].toInt())
                q.offer(node.left)
            }
            i++
            if (i < list.size && list[i] != "null") {
                node.right = TreeNode(list[i].toInt())
                q.offer(node.right)
            }
            i++
        }
        return root
    }
}