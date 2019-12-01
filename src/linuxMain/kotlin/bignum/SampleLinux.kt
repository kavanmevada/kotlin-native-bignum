package bignum

import kotlin.system.measureNanoTime

fun hello(): String = "Hello, Kotlin/Native!"

fun main() {
    println(hello())

    val kavan: Int = 0
}



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