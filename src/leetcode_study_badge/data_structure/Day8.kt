package leetcode_study_badge.data_structure

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


    fun multiply(num1: String, num2: String): String {
        if ("0" == num1 || "0" == num2)
            return "0"

        val list = Array(num1.length + num2.length - 1){0}

        for (i in num1.length - 1 downTo 0) {
            for (j in num2.length - 1 downTo 0) {
                list[i + j] += (num1[i] - '0') * (num2[j] - '0')
            }
        }

        for (i in list.size - 1 downTo 1) {
            list[i - 1] += list[i] / 10

            list[i] %= 10

        }


        val builder = StringBuilder()
        list.forEach {
            builder.append(it)
        }

        return builder.toString()
    }

}

fun main() {
    val result = Day8().groupAnagramsOneLine(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))

    println(Day8().multiply("145","12"))
}
