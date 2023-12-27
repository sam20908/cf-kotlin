package dsa

private class RabinKarp(s: String) {
    val M1 = 1000000007L
    val M2 = 1000000009L
    val P1 = 31L
    val P2 = 37L
    val n = s.length
    val h1 = LongArray(n + 1)
    val h2 = LongArray(n + 1)

    init {
        fun precompute(h: LongArray, p: Long, m: Long) {
            var pp = 1L
            for (i in 0..<n) {
                h[i + 1] = (h[i] + s[i].code * pp) % m
                pp = (pp * p) % m
            }
        }
        precompute(h1, P1, M1)
        precompute(h2, P2, M2)
    }

    fun hash(l: Int, r: Int): Pair<Long, Long> = (h1[r + 1] - h1[l] + M1) % M1 to (h2[r + 1] - h2[l] + M2) % M2
    fun hash(): Pair<Long, Long> = h1[n] to h2[n]
}