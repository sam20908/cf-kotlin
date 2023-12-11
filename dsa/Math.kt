package dsa

private infix fun Int.gcd(other: Int): Int {
    var a = this
    var b = other
    while (b > 0) {
        a %= b;
        a = b.also { b = a }
    }
    return a;
}

private fun powMod(a: Long, b: Long, m: Long): Long {
    @Suppress("NAME_SHADOWING") var a = a % m
    @Suppress("NAME_SHADOWING") var b = b
    var ans = 1L
    while (b > 0) {
        if ((b and 1) > 0) ans = ans * a % m
        a = a * a % m
        b = b shr 1
    }
    return ans
}
