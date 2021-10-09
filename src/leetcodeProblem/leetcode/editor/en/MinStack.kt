//Design a stack that supports push, pop, top, and retrieving the minimum
//element in constant time. 
//
// Implement the MinStack class: 
//
// 
// MinStack() initializes the stack object. 
// void push(int val) pushes the element val onto the stack. 
// void pop() removes the element on the top of the stack. 
// int top() gets the top element of the stack. 
// int getMin() retrieves the minimum element in the stack. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// Methods pop, top and getMin operations will always be called on non-empty 
//stacks. 
// At most 3 * 10⁴ calls will be made to push, pop, top, and getMin. 
// 
// Related Topics Stack Design 👍 6128 👎 538


package leetcodeProblem.leetcode.editor.en

import java.util.*

class MinStack {
    fun solution() {
    }

    //below code will be used for submission to leetcode (using plugin of course)
    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack() {
        private val stack = Stack<Int>()
        private val minStack = Stack<Int>()

        fun push(x: Int) {
            stack.push(x)

            if (minStack.empty() || x <= minStack.peek()) {
                minStack.push(x)
            }
        }

        fun pop() {
            val el = stack.pop()

            if (!minStack.empty() && el == minStack.peek()) {
                minStack.pop()
            }
        }

        fun top(): Int {
            return stack.peek()
        }

        fun getMin(): Int {
            return minStack.peek()
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * var obj = MinStack()
     * obj.push(`val`)
     * obj.pop()
     * var param_3 = obj.top()
     * var param_4 = obj.getMin()
     */
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {}
  

