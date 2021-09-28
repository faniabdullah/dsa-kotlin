package leetcode_badge.algorithm

class Day6 {

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val s1map = IntArray(26)
        val s2map = IntArray(26)
        for (i in s1.indices) {
            s1map[s1[i] - 'a']++
            s2map[s2[i] - 'a']++
        }
        for (i in 0 until s2.length - s1.length) {
            if (matches(s1map, s2map)) return true
            s2map[s2[i + s1.length] - 'a']++
            s2map[s2[i] - 'a']--
        }
        return matches(s1map, s2map)
    }

    private fun matches(s1map: IntArray, s2map: IntArray): Boolean {
        for (i in 0..25) {
            if (s1map[i] != s2map[i]) return false
        }
        return true
    }

    fun lengthOfLongestSubstring(s: String): Int {
        var longest = 0
        var currentRunStartIndex = 0
        val lastSeenIndices = IntArray(128)
        s.toCharArray().forEachIndexed { index, char ->
            with(char.code) {
                currentRunStartIndex = maxOf(lastSeenIndices[this], currentRunStartIndex)
                longest = maxOf(longest, index - currentRunStartIndex + 1)
                lastSeenIndices[this] = index + 1

                println(" index $index - $currentRunStartIndex and $longest , lastSeen  ${lastSeenIndices[this]}")
            }
        }
        return longest
    }

}


fun main() {
    println(Day6().checkInclusion("fabi", "ibafsalsaila"))
    println(Day6().lengthOfLongestSubstring("abcabcbb"))
}