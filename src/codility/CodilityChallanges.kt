package codility


class CodilityChallanges {

    fun solution1(A: IntArray, K: Int): Boolean {
        val n = A.size
        for (i in 0 until n - 1) {
            if ((A[i] + 1 < A[i + 1]) && (A[i] + 1 != A[i + 1]))
                return false
        }
        if (A[0] != 1 || A[n - 1] != K)
            return false
        else
            return true
    }


    private fun digit_sum(n: Int): Int {
        var n = n
        var sum = 0
        while (n >= 10) {
            sum += n % 10
            n /= 10
        }
        sum += n
        return sum
    }

    fun solution(A: IntArray): Int {
        val hash = HashMap<Int, ArrayList<Int>>()
        var sum = -1
        for (i in A.indices) {
            val temp = digit_sum(A[i])
            if (hash.containsKey(temp)) {
                hash[temp]?.add(A[i])
            } else {
                val nums = ArrayList<Int>()
                nums.add(A[i])
                hash[temp] = nums
            }
        }
        for (key in hash.keys) {
            if (hash[key]!!.size < 2) continue
            hash[key]?.sort()
            val num = ArrayList(hash[key])
            val n = num.size
            sum = maxOf(sum, num[n - 1] + num[n - 2])
        }
        return sum
    }
}


fun main() {
    val problem = CodilityChallanges()
    println(problem.solution(intArrayOf(51, 32, 43)))
}