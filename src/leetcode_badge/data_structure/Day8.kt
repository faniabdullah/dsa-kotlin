package leetcode_badge.data_structure

class Day8 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val hashToStrs = HashMap<Int, MutableList<String>>()
        for (str in strs) {
            hashToStrs.getOrPut(hash(str)) { mutableListOf() }.add(str)
        }

        return hashToStrs.values.toList()
    }

    private fun hash(str: String): Int {
        val freqs = IntArray(26) { 0 }
        for (ch in str) {
            ++freqs[ch - 'a']
        }
        return freqs.contentHashCode()
    }

    // One line solution
    fun groupAnagramsOneLine(strs: Array<String>): List<List<String>> = mutableMapOf<String, MutableList<String>>().apply {
        strs.forEach {
            getOrPut(it.toCharArray().sorted().joinToString("")) { mutableListOf() }.add(it)
        }
    }.values.toList()

}

fun main() {
    val result = Day8().groupAnagramsOneLine(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))

    result.forEach {
        println(it)
    }
}
