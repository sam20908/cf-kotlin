package dsa

private class Factorials(n: Int, val m: Int) {
    val fact = LongArray(n + 1) { 1 }
    val inv = LongArray(n + 1) { 1 }
    val ifact = LongArray(n + 1) { 1 }

    init {
        for (i in 2..n) {
            fact[i] = fact[i - 1] * i % m
            inv[i] = (m - m / i) * inv[m % i] % m
            ifact[i] = ifact[i - 1] * inv[i] % m
        }
    }

    fun ncr(n: Int, k: Int): Long = fact[n] * ifact[n - k] % m * ifact[k] % m
    fun npr(n: Int, k: Int): Long = fact[n] * ifact[n - k] % m
}