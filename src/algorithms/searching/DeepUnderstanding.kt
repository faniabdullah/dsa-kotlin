package algorithms.searching

class DeepUnderstanding {
    fun solutionBNS(nums1: IntArray, low: Int, size: Int, target: Int): Int {


        if (size >= low) {
            val mid: Int = low + (size - low) / 2
            return when {
                nums1[mid] == target -> {
                    mid
                }
                nums1[mid] > target -> {
                    solutionBNS(nums1, low, mid - 1, target)
                }
                else -> {
                    solutionBNS(nums1, mid + 1, size, target)
                }
            }
        }
        return -1
    }
}


fun main() {
    val number = intArrayOf(2, 5, 8, 12, 16, 23, 38, 56, 72, 92)
    println(DeepUnderstanding().solutionBNS(number, 0, number.size - 1, 92))
}