package codility

import java.util.*


class StoneWall {
    fun solution(H: IntArray): Int {

        // main idea: need to use "stack" to check when we need a new block
        val st = Stack<Int>()
        var numBlock = 0

        // note: H[i] is the ith height of the wall
        for (i in H.indices) {

            // step 1: "stack is not empty" AND "from high to low"
            // then, "pop" (it is the key point, be careful)
            while (st.isEmpty() == false && st.peek() > H[i]) {
                st.pop()
            }
            // step 2: if the stack is empty
            if (st.isEmpty()) {
                numBlock++ // add a block
                st.push(H[i]) // push the height
            } else if (st.peek() == H[i]) {
            } else if (st.peek() < H[i]) {
                numBlock++ // add a block
                st.push(H[i]) // push the height
            }
        }
        return numBlock
    }
}