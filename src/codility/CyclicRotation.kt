package codility

class CyclicRotation {
    fun solution(A: IntArray, K: Int): IntArray {
        if (A.isEmpty()) return A
        var k = K
        k %= A.size
        reverse(A, 0, A.size - 1)
        reverse(A, 0, k - 1)
        reverse(A, k, A.size - 1)
        return A
    }

    fun reverse(arr: IntArray, l: Int, r: Int) {
        var left = l
        var right = r
        while (left < right) {
            val temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp
            left++
            right--
        }
    }
}