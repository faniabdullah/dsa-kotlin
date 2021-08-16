package compotitiveProgramming.easy

class SearchChannel {
    fun solution(channel: MutableMap<String, IntArray>, target: Int): String {
        var result = ""
        var minSize = Int.MAX_VALUE
        channel.forEach { (s, ints) ->
            ints.forEach {
                if (it == target) {
                    if (ints.size < minSize) {
                        result = s
                        minSize = ints.size
                    }
                }
            }
        }

        return result
    }
}

fun main() {
    val searchChannel = SearchChannel()
    val mapSearh = mutableMapOf<String, IntArray>()
    mapSearh["Channel 1"] = intArrayOf(1, 2, 3, 4)
    mapSearh["Channel 2"] = intArrayOf(1, 2, 3, 4, 4, 5, 6, 7, 2, 1)
    mapSearh["Channel 3"] = intArrayOf(100, 20, 2, 12, 4, 12, 4, 1, 23, 12, 12, 433, 123)
    println(searchChannel.solution(mapSearh, 4))
}