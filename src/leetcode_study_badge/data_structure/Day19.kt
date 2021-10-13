package leetcode_study_badge.data_structure

import java.util.*

class Day19 {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val countWhomTrustI = IntArray(n)
        val countWhomTrustMe = IntArray(n)
        for ((who, whom) in trust) {
            countWhomTrustI[who - 1] = countWhomTrustI[who - 1] + 1
            countWhomTrustMe[whom - 1] = countWhomTrustMe[whom - 1] + 1
        }
        for (i in 0 until n) {
            if (countWhomTrustMe[i] == n- 1 && countWhomTrustI[i] == 0) {
                return i + 1
            }
        }
        return -1
    }

    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>, inDegree: IntArray = IntArray(n)) =
        edges.map { inDegree[it[1]]++ }
            .run { inDegree.withIndex().filter { it.value == 0 }.map { it.index } }
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = mutableSetOf<Int>()
        val queue = LinkedList<Int>().also { it.offer(0); visited.add(0) }
        while (queue.isNotEmpty()) {
            val room = queue.poll()
            for (neighbor in rooms[room]) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor)
                    queue.offer(neighbor)
                }
            }
        }
        return visited.size == rooms.size
    }
}