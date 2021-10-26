package codility

/*
We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0


There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].


 */





import kotlin.math.abs

class NumberOfDiscIntersections {
    fun solution(A: IntArray): Int {
        val n = A.size
        val starts = IntArray(n + 1)
        val ends = IntArray(n + 1)
        for (i in 0 until n) {
            val discRadius = abs(A[i])
            val indexOfBeginning = i.toLong() - discRadius.toLong()
            starts[(if (indexOfBeginning < 0) 0 else indexOfBeginning).toInt()]++
            val indexOfEnd: Long = i.toLong() + discRadius.toLong()
            val result = if (indexOfEnd > n) n else indexOfEnd
            ends[result.toString().toInt()]++
        }
        var numberOfIntersections = 0
        var numberOfActiveCircles = 0
        for (i in 0 until n + 1) {
            val numberOfNewCircles = starts[i]
            if (numberOfNewCircles > 0) {
                numberOfIntersections += (numberOfActiveCircles * numberOfNewCircles
                        + (numberOfNewCircles - 1) * numberOfNewCircles / 2)
                numberOfActiveCircles += numberOfNewCircles
                if (numberOfIntersections > 10000000) {
                    return -1
                }
            }
            if (ends[i] > 0) {
                numberOfActiveCircles -= ends[i]
            }
        }
        return numberOfIntersections
    }
}