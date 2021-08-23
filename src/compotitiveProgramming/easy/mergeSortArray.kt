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

    fun mergeInPlace(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var addPointer = nums1.size - 1 // we add to the result array from the end
        var pointer1 = m - 1 // start to check from the end
        var pointer2 = n - 1 // start to check from the end

        // we care only about `pointer2` because the first array can be empty, but the second one should have at least one element
        while (addPointer >= 0 && pointer2 >= 0) {
            val v1 = nums1.getOrNull(pointer1)
            val v2 = nums2.getOrNull(pointer2)

            // add the bigger value to the end of result list and move pointers
            if (v1 != null && v2 != null && v1 > v2) {
                nums1[addPointer] = v1
                addPointer--
                pointer1--
            } else {
                nums1[addPointer] = v2!! // don't worry we have this condition in `while`
                addPointer--
                pointer2--
            }
        }


    }

    fun mergeInPlaceQuick(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        for (i in 0 until n) {
            nums1[m + i] = nums2[i]
        }
        nums1.sort()
    }
}

fun main() {
    val mergeSortArray = MergeSortArray()
    var nums1 = intArrayOf(1, 4, 6, 0, 0, 0)
    val result = mergeSortArray.mergeInPlace(nums1, 3, intArrayOf(1, 5, 6), 3)
    println(nums1.contentToString())
}