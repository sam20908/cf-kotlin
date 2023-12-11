package dsa

private class Sieve(n: Int) {
    val p = ArrayList<Int>()
    val pd = IntArray(n + 1) { it }

    init {
        for (i in 2..n) {
            if (pd[i] == i) p.add(i)
            for (j in p.indices) {
                if (i * p[j] > n) break
                pd[i * p[j]] = p[j]
                if (i % p[j] == 0) break
            }
        }
    }

    fun isPrime(x: Int): Boolean = x > 1 && pd[x] == x
}
