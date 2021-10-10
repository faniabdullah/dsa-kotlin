package data_structure.string

class NumberOfMatching {
    fun numMatchingSubseq(S: String, words: Array<String>): Int {
        return words.count { it.isSubsequenceOf(S) }
    }

    private fun String.isSubsequenceOf(S: String): Boolean {
        var p = 0
        var q = 0
        while (p < S.length && q < this.length) {
            if (S[p] == this[q]) {
                p++
                q++
            } else {
                p++
            }
        }
        return q == this.length
    }

}