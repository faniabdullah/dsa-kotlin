package leetcode_badge.data_structure

class Day9 {
    fun findRepeatedDnaSequences(s: String): List<String> {

        val sequenceCountMap = HashMap<String, Int>()

        val sequenceCheckLength = 10

        for (index in 0..s.length - sequenceCheckLength) {
            val substring = s.substring(index, index + sequenceCheckLength)
            sequenceCountMap[substring] = (sequenceCountMap[substring] ?: 0) + 1
        }

        return sequenceCountMap.filterValues { it > 1 }.keys.toList()
    }
}