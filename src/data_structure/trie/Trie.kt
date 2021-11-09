package data_structure.trie

class Trie() {
    /** Initialize your data structure here. */
    class TrieNode {
        val children = Array<TrieNode?>(26) { null }
        var isWord = false
    }

    val trieTree = TrieNode()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var p = trieTree

        for (w in word) {
            val i = w - 'a'
            if (p.children[i] == null) p.children[i] = TrieNode()
            p = p.children[i]!!
        }
        p.isWord = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var p = trieTree

        for (w in word) {
            val i = w - 'a'
            if (p.children[i] == null) return false
            p = p.children[i]!!
        }
        return p.isWord
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var p = trieTree

        for (w in prefix) {
            val i = w - 'a'
            if (p.children[i] == null) return false
            p = p.children[i]!!
        }

        return true
    }

}