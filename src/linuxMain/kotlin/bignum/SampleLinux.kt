package bignum

import bignum.compute.*
import kotlin.system.measureNanoTime


fun hello(): String = "Hello, Kotlin/Native!"

fun main() {
    println(hello())


    val kavan: Int = 0
}

















fun powerStrings(sa: String, sb: String, mod: Long): Long { // We convert strings to number
    var a: Long = 0
    var b: Long = 0
    // calculating a % MOD
    for (i in 0 until sa.length) {
        a = (a * 10 + (sa[i] - '0')) % mod
    }
    // calculating b % (MOD - 1)
    for (i in 0 until sb.length) {
        b = (b * 10 + (sb[i] - '0')) % (mod - 1)
    }
    // Now a and b are long long int. We
    // calculate a^b using modulo exponentiation
    return powerLL(a, b, mod)
}

fun powerLL(x: Long, n: Long, mod: Long): Long {
    var x = x
    var n = n
    var result: Long = 1
    while (n > 0) {
        if (n % 2 == 1L) {
            result = result * x % mod
        }
        n = n / 2
        x = x * x % mod
    }
    return result
}




//100011111100




// Extra
inline fun <R> measures(block1: () -> R, block2: () -> R) {
    val t1 = measureNanoTime {
        for (i in 0 until 10000) {
            block1()
        }
    }
    val t2 = measureNanoTime {
        for (i in 0 until 10000) {
            block2()
        }
    }
    println("${block1()} $t1\n${block2()} $t2")
}