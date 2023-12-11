package dsa

private class FenwickTree(n: Int) {
    val t = IntArray(n + 1) // one-indexed
    val n = n + 1
    fun update(i: Int, v: Int) {
        @Suppress("NAME_SHADOWING") var i = i
        while (i < n) {
            t[i] += v
            i += i and -i
        }
    }

    fun query(i: Int): Int {
        @Suppress("NAME_SHADOWING") var i = i
        var ans = 0
        while (i > 0) {
            ans += t[i]
            i -= i and -i
        }
        return ans
    }
}
