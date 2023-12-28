package dsa

class TrieChar {
    class Node {
        val next = Array<Node?>(26) { null }
        var end = false
    }

    val root = Node()
    val t = ArrayList<Node>().also { it.add(root) }

    fun add(s: String) {
        var cur = root
        for (c in s) {
            cur = cur.next[c - 'a'] ?: run {
                t.add(Node())
                t.last()
            }
        }
        cur.end = true
    }

    fun advance(cur: Node?, c: Char): Node? = cur?.next?.get(c - 'a')
}