package compotitiveProgramming.easy

class MergeSortArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
        val arr = IntArray(m + n)
        var i = 0
        var j = 0
        var counter = 0

        while (i < m || j < n) {
            when {
                i >= m -> {
                    arr[counter] = nums2[j]
                    j++
                }
                j >= n -> {
                    arr[counter] = nums1[i]
                    i++
                }
                nums1[i] <= nums2[j] -> {
                    arr[counter] = nums1[i]
                    i++
                }
                else -> {
                    arr[counter] = nums2[j]
                    j++
                }
            }
            counter++
        }

        return arr
    }
}

fun main() {
    val mergeSortArray = MergeSortArray()
    val result = mergeSortArray.merge(intArrayOf(1, 4, 6, 0, 0, 0), 3, intArrayOf(1, 5, 6, 9, 0), 4)
    println(result.contentToString())
}