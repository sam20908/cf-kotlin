package dsa

import kotlin.math.*

private class SegmentTreePoint(val n: Int) {
    val t = IntArray(4 * n)
    fun update(i: Int, v: Int) {
        fun dfs(tl: Int, tr: Int, m: Int) {
            if (tl == tr) t[m] += v
            else {
                val tm = (tl + tr) / 2
                if (i <= tm) dfs(tl, tm, 2 * m) else dfs(tm + 1, tr, 2 * m + 1)
                val a = t[2 * m]
                val b = t[2 * m + 1]
                t[m] = a + b
            }
        }
        dfs(0, n - 1, 1)
    }

    fun query(l: Int, r: Int): Int {
        fun dfs(l: Int, r: Int, tl: Int, tr: Int, m: Int): Int {
            if (l > r) return 0
            if (tl == l && tr == r) return t[m]
            val tm = (tl + tr) / 2
            val a = dfs(l, min(tm, r), tl, tm, 2 * m)
            val b = dfs(max(tm + 1, l), r, tm + 1, tr, 2 * m + 1)
            return a + b
        }
        return dfs(l, r, 0, n - 1, 1)
    }
}
