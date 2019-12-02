package bignum

import bignum.compute.addition
import bignum.compute.isGreater
import bignum.compute.multiply
import bignum.compute.substraction
import kotlin.system.measureNanoTime


fun hello(): String = "Hello, Kotlin/Native!"

fun main() {
    println(hello())

    //println(powerStrings("2", "3", (1e9 + 7).toLong()))

    divide("6797673498237646797673498237645021374589888342350213745898883423", "6797673498237645021374589888")
    //1000000000000000261309830313292584851


    val kavan: Int = 0
}





fun divide(x: String, y: String) {

    //TODO y must less then or equal x

    val pieceSize = y.length

    var num = x.substring(0, pieceSize)

    var quo = ""
    var remainder = ""

    for (i in pieceSize-1 until x.length) {
        for (j in 0..10) {
            val currA = multiply(y, "$j")
            val currB = multiply(y, "${j + 1}")

            if (currB.isGreater(num)) {
                quo += j

                val sub = substraction(num, currA)

                if (i + 1 < x.length) {
                    num = addition(sub + "0", "${x[i + 1]}")
                } else {
                    remainder = sub
                }

                break
            }
        }
    }

    println("quo:$quo rem:$remainder")

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