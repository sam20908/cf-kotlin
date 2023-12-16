import java.io.*
import java.util.*
import java.math.*
import kotlin.math.*

private val reader = System.`in`.bufferedReader()
private val writer = PrintWriter(System.out, false)
private var tokenizer = StringTokenizer("")

private fun read(): String {
    while (!tokenizer.hasMoreTokens()) tokenizer = StringTokenizer(reader.readLine())
    return tokenizer.nextToken()
}

private fun readInt(): Int = read().toInt()
private fun readLong(): Long = read().toLong()
private fun eprintln(m: Any) = System.err.println(m)

private fun solve() = writer.apply {}

fun main() {
    repeat(read().toInt()) { solve() }
    writer.flush()
}