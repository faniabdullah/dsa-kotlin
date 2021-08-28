package algorithms.searching

class DeepUnderstanding {
    fun solutionBNS(nums1: IntArray, low: Int, size: Int, target: Int): Int {
        val mid: Int = (low + size) / 2
        return when {
            low > size -> {
                -1
            }
            nums1[mid] == target -> {
                mid
            }
            target > nums1[mid] -> {
                solutionBNS(nums1, mid + 1, size, target)
            }
            else -> {
                solutionBNS(nums1, low, mid, target)
            }
        }
    }
}


fun main() {
    val number = intArrayOf(2, 5, 8, 12, 16, 23, 38, 56, 72, 91)
    println(DeepUnderstanding().solutionBNS(number, 0, number.size-1, 91))
}