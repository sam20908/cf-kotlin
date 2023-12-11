package dsa

private class UnionFind(n: Int) {
    val s = IntArray(n) { 1 }
    val p = IntArray(n) { it }

    fun unite(u: Int, v: Int) {
        @Suppress("NAME_SHADOWING") var u = find(u)
        @Suppress("NAME_SHADOWING") var v = find(v)
        if (u == v) return
        if (size(u) < size(v)) u = v.also { v = u }
        s[u] += s[v]
        p[v] = u
    }

    fun find(u: Int): Int = if (p[u] == u) u else run { p[u] = find(p[u]); return p[u] }
    fun size(u: Int): Int = s[find(u)]
}
