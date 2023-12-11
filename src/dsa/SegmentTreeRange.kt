package dsa

import kotlin.math.*

private class SegmentTreeRange(val n: Int) {
    val t = IntArray(4 * n)
    val p = IntArray(4 * n)
    fun propagate(tl: Int, tr: Int, m: Int) {
        t[m] += p[m] * (tr - tl + 1)
        if (tl != tr) {
            p[2 * m] += p[m]
            p[2 * m + 1] += p[m]
        }
        p[m] = 0
    }

    fun update(l: Int, r: Int, v: Int) {
        fun dfs(l: Int, r: Int, tl: Int, tr: Int, m: Int) {
            propagate(tl, tr, m)
            if (l > r) return
            if (tl == l && tr == r) {
                p[m] += v
                propagate(tl, tr, m)
            } else {
                val tm = (tl + tr) / 2
                dfs(l, min(tm, r), tl, tm, 2 * m)
                dfs(max(tm + 1, l), r, tm + 1, tr, 2 * m + 1)
                val a = t[2 * m]
                val b = t[2 * m + 1]
                t[m] = a + b
            }
        }
        dfs(l, r, 0, n - 1, 1)
    }

    fun query(l: Int, r: Int): Int {
        fun dfs(l: Int, r: Int, tl: Int, tr: Int, m: Int): Int {
            propagate(tl, tr, m)
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
