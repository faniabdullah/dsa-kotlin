//Design the CombinationIterator class:
//
// 
// CombinationIterator(string characters, int combinationLength) Initializes 
//the object with a string characters of sorted distinct lowercase English letters 
//and a number combinationLength as arguments. 
// next() Returns the next combination of length combinationLength in 
//lexicographical order. 
// hasNext() Returns true if and only if there exists a next combination. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", 
//"hasNext"]
//[["abc", 2], [], [], [], [], [], []]
//Output
//[null, "ab", true, "ac", true, "bc", false]
//
//Explanation
//CombinationIterator itr = new CombinationIterator("abc", 2);
//itr.next();    // return "ab"
//itr.hasNext(); // return True
//itr.next();    // return "ac"
//itr.hasNext(); // return True
//itr.next();    // return "bc"
//itr.hasNext(); // return False
// 
//
// 
// Constraints: 
//
// 
// 1 <= combinationLength <= characters.length <= 15 
// All the characters of characters are unique. 
// At most 10⁴ calls will be made to next and hasNext. 
// It's guaranteed that all calls of the function next are valid. 
// 
// Related Topics String Backtracking Design Iterator 👍 930 👎 76


package leetcodeProblem.leetcode.editor.en

class IteratorForCombination {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class CombinationIterator(val characters: String, val combinationLength: Int) {
        val n = characters.length

        //current combination
        var curr = ""

        fun next(): String {
            //first combination is first consecutive combinationLength letters from characters
            if (curr == "") {
                curr = characters.substring(0 until combinationLength)
                return curr
            }
            var i = 0

            //count suffix length that is equal to characters suffix
            while (curr[combinationLength - i - 1] == characters[n - i - 1]) i++

            //index of the next letter
            val from = characters.indexOf(curr[combinationLength - i - 1]) + 1

            //concatenate result
            curr = curr.substring(0 until combinationLength - i - 1) + characters.substring(from..from + i)
            return curr
        }

        fun hasNext(): Boolean {
            return curr != characters.substring(characters.lastIndex - combinationLength + 1..characters.lastIndex)
        }
    }

    /**
     * Your CombinationIterator object will be instantiated and called as such:
     * var obj = CombinationIterator(characters, combinationLength)
     * var param_1 = obj.next()
     * var param_2 = obj.hasNext()
     */
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  

