package algorithms.sliding_window

fun lengthOfLongestSubstring(s: String): Int {
    var left = 0
    var right = 0
    var max = 0
    var hashSet = mutableSetOf<Char>()
    while (right < s.length) {
        if (hashSet.contains(s[right]).not()) {
            hashSet.add(s[right])
            right++
            max = maxOf(max, hashSet.size)
        } else {
            hashSet.remove(s[left])
            left++
        }
    }
    return max
}