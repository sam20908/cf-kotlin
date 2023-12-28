package dsa

import java.util.ArrayList

private class AhoCorasick(words: Array<String>) {
    val m = words.sumOf { it.length }
    val next = Array(m + 1) { IntArray(26) { -1 } }
    val link = IntArray(m + 1)
    val nextMatch = IntArray(m + 1)
    val matches = Array(m + 1) { ArrayList<Int>() }

    init {
        var newNode = 1
        for ((i, word) in words.withIndex()) {
            var cur = 0
            for (c in word) {
                if (next[cur][c - 'a'] == -1) next[cur][c - 'a'] = newNode++
                cur = next[cur][c - 'a']
            }
            matches[cur].add(i)
        }
        val q = ArrayDeque<Int>()
        for (i in 0..<26) {
            if (next[0][i] != -1) q.add(next[0][i])
            else next[0][i] = 0
        }
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            for (v in 0..<26) if (next[u][v] != -1) {
                var curLink = link[u]
                while (next[curLink][v] == -1) curLink = link[curLink]
                link[next[u][v]] = next[curLink][v]
                nextMatch[next[u][v]] =
                    if (matches[link[next[u][v]]].isNotEmpty()) link[next[u][v]] else nextMatch[link[next[u][v]]]
                if (next[u][v] != -1) q.add(next[u][v])
            }
        }
    }

    fun matches(s: String): ArrayList<Pair<Int, Int>> {
        val ans = ArrayList<Pair<Int, Int>>()
        var cur = 0
        for ((i, c) in s.withIndex()) {
            while (next[cur][c - 'a'] == -1) cur = link[cur]
            cur = next[cur][c - 'a']
            var cur2 = cur
            while (cur2 != 0) {
                for (j in matches[cur2]) ans.add(i to j)
                cur2 = nextMatch[cur2]
            }
        }
        return ans
    }
}