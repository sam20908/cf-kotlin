package dsa

private fun firstTrue(lo: Int, hi: Int, f: (Int) -> Boolean): Int {
    @Suppress("NAME_SHADOWING") var hi = hi + 1
    @Suppress("NAME_SHADOWING") var lo = lo
    while (lo < hi) {
        val mid = lo + (hi - lo) / 2
        if (f(mid)) hi = mid else lo = mid + 1
    }
    return lo
}

private fun lastTrue(lo: Int, hi: Int, f: (Int) -> Boolean): Int {
    @Suppress("NAME_SHADOWING") var hi = hi
    @Suppress("NAME_SHADOWING") var lo = lo - 1
    while (lo < hi) {
        val mid = lo + (hi - lo + 1) / 2
        if (f(mid)) lo = mid else hi = mid - 1
    }
    return lo
}
