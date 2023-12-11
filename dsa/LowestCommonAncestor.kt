package dsa

private class LowestCommonAncestor(g: Array<ArrayList<Int>>, root: Int, val k: Int = 25) {
    val n = g.size
    val tin = IntArray(n)
    val tout = IntArray(n)
    val up = IntArray(n * (k + 1))

    init {
        var time = 0
        fun dfs(u: Int, p: Int) {
            up[u] = p
            tin[u] = ++time
            for (v in g[u]) if (v != p) dfs(v, u)
            tout[u] = ++time
        }
        dfs(root, root)
        for (i in 1..k) for (j in 0 until n) up[i * n + j] = up[(i - 1) * n + up[(i - 1) * n + j]]
    }

    fun isAncestor(u: Int, v: Int): Boolean = tin[u] <= tin[v] && tout[u] >= tout[v]
    fun query(u: Int, v: Int): Int {
        if (isAncestor(u, v)) return u
        @Suppress("NAME_SHADOWING") var u = u
        for (i in k downTo 0) if (!isAncestor(up[i * n + u], v)) u = up[i * n + u]
        return up[u]
    }
}
