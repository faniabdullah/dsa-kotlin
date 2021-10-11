package data_structure.tree


class TreeNodeString(var treeValue: String?) {
    var right: TreeNodeString? = null
    var left: TreeNodeString? = null
}

class TreeHelper() {

    fun preOrderPrint(node: TreeNodeString?): String {
        if (node == null) {
            return ""
        }
        var result = node.treeValue
        val resultLeft = preOrderPrint(node.left)
        result = result + resultLeft + preOrderPrint(node.right)
        return result
    }

    fun inOrderPrint(node: TreeNodeString?): String {
        if (node == null) {
            return ""
        }
        val resultLeft = inOrderPrint(node.left)
        var result = node.treeValue
        result = resultLeft + result + inOrderPrint(node.right)
        return result
    }

    fun postOrderPrint(node: TreeNodeString?): String {
        if (node == null) {
            return ""
        }
        val resultLeft = postOrderPrint(node.left)
        return resultLeft + postOrderPrint(node.right) + node.treeValue
    }
}


fun main() {
    val treeHelper = TreeHelper()
    val treeNode = TreeNodeString("A")
    treeNode.left = TreeNodeString("B")
    treeNode.left?.left = TreeNodeString("D")
    treeNode.left?.right = TreeNodeString("E")
    treeNode.left?.right?.left = TreeNodeString("H")
    treeNode.right = TreeNodeString("C")
    treeNode.right?.right = TreeNodeString("G")
    treeNode.right?.left = TreeNodeString("F")

    println(treeHelper.preOrderPrint(treeNode))

    println(treeHelper.inOrderPrint(treeNode))

    println(treeHelper.postOrderPrint(treeNode))
}
