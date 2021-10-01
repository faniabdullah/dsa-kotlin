package data_structure.tree

import java.util.*


class TreeBFS {
    //  https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/


    // function to determine level of each node starting
    // from x using BFS
    fun printLevels(graph: Vector<Vector<Int>>, V: Int, x: Int) {
        // array to store level of each node
        var x = x
        val level = IntArray(V)
        val marked = BooleanArray(V)

        // create a queue
        val que: Queue<Int> = LinkedList()

        // enqueue element x
        que.add(x)

        // initialize level of source node to 0
        level[x] = 0

        // marked it as visited
        marked[x] = true

        // do until queue is empty
        while (que.size > 0) {

            // get the first element of queue
            x = que.peek()

            // dequeue element
            que.remove()

            // traverse neighbors of node x
            for (i in graph[x].indices) {
                // b is neighbor of node x
                val b = graph[x][i]

                // if b is not marked already
                if (!marked[b]) {

                    // enqueue b in queue
                    que.add(b)

                    // level of b is level of x + 1
                    level[b] = level[x] + 1

                    // mark b
                    marked[b] = true
                }
            }
        }

        // display all nodes and their levels
        println(
            "Nodes"
                    + " "
                    + "Level"
        )
        for (i in 0 until V) println(" " + i + " --> " + level[i])
    }
}

fun main(){
    // adjacency graph for tree
    // adjacency graph for tree
    val V = 8
    val graph = Vector<Vector<Int>>()

    for (i in 0 until V + 1) graph.add(Vector())

    graph[0].add(1)
    graph[0].add(2)
    graph[1].add(3)
    graph[1].add(4)
    graph[1].add(5)
    graph[2].add(5)
    graph[2].add(6)
    graph[6].add(7)

    // call levels function with source as 0

    // call levels function with source as 0
    TreeBFS().printLevels(graph, V, 0)
}
