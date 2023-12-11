package dsa

private fun <U, V> comparePairs(x: Pair<U, V>, y: Pair<U, V>)
        where U : Comparable<U>,
              V : Comparable<V> = when {
    x.first != y.first -> if (x.first <= y.first) -1 else 1
    else -> if (x.second <= y.second) -1 else 1
}