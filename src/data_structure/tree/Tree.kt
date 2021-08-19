package data_structure.tree

class TreeNode(var treeValue: String?) {
    var right: TreeNode? = null
    var left: TreeNode? = null
}

class TreeHelper() {

    fun preOrderPrint(node: TreeNode?): String {
        if (node == null) {
            return ""
        }
        var result = node.treeValue
        val resultLeft = preOrderPrint(node.left)
        result = result + resultLeft + preOrderPrint(node.right)
        return result
    }

    fun inOrderPrint(node: TreeNode?): String {
        if (node == null) {
            return ""
        }
        val resultLeft = inOrderPrint(node.left)
        var result = node.treeValue
        result = resultLeft + result + inOrderPrint(node.right)
        return result
    }

    fun postOrderPrint(node: TreeNode?): String {
        if (node == null) {
            return ""
        }
        val resultLeft = postOrderPrint(node.left)
        return resultLeft + postOrderPrint(node.right) + node.treeValue
    }
}


fun main() {
    val treeHelper = TreeHelper()
    val treeNode = TreeNode("A")
    treeNode.left = TreeNode("B")
    treeNode.left?.left = TreeNode("D")
    treeNode.left?.right = TreeNode("E")
    treeNode.left?.right?.left = TreeNode("H")
    treeNode.right = TreeNode("C")
    treeNode.right?.right = TreeNode("G")
    treeNode.right?.left = TreeNode("F")

    println(treeHelper.preOrderPrint(treeNode))

    println(treeHelper.inOrderPrint(treeNode))

    println(treeHelper.postOrderPrint(treeNode))
}
