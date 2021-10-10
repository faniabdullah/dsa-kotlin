package algorithms.bit_manipulation

class RangeBitWiseAnd {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        if (right == left) return left

        var n = right - left

        n = n or (n ushr 1)
        n = n or (n ushr 2)
        n = n or (n ushr 4)
        n = n or (n ushr 8)
        n = n or (n ushr 16)

        n = (n + 1)
        n = n ushr 1
        if (n < 0) return 0

        n = (n or (n - 1)).inv()

        return n and right and left
    }
}