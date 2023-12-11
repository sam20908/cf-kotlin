package dsa

import kotlin.math.*

private class SparseTable(v: IntArray, val k: Int = 25) {
    val n = v.size
    val dp = v.copyOf(n * (k + 1))

    init {
        for (i in 1..k) for (j in 0..n - (1 shl i)) {
            val a = dp[(i - 1) * n + j]
            val b = dp[(i - 1) * n + j + (1 shl (i - 1))]
            dp[i * n + j] = min(a, b)
        }
    }

    fun query(l: Int, r: Int): Int {
        @Suppress("NAME_SHADOWING") var l = l
        var ans = 2000000000
        for (i in k downTo 0) if (l + (1 shl i) <= r) {
            val a = ans
            val b = dp[i * n + l]
            l += 1 shl i
            ans = min(a, b)
        }
        return ans
    }

    fun queryFast(l: Int, r: Int): Int { // only works if operation is idempotent!
        val p = 31 - (r - l + 1).countLeadingZeroBits()
        val a = dp[p * n + l]
        val b = dp[p * n + (r - (1 shl p) + 1)]
        return max(a, b)
    }
}
