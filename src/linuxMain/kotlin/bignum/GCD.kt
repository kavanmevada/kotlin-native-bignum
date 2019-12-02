package bignum


fun reduceB(a: Int, b: String): Int {
    var result = 0
    for (i in b.indices) {
        result = ( result * 10 + (b[i]-'0')) % a
    }
    return result
}

fun gcd(reduceNum: Int, b: Int): Int {
    return if (b==0) reduceNum else gcd(b, reduceNum % b)
}

fun gcdLarge(a: Int, b: String): Int {
    val num = reduceB(a, b)
    return gcd(num, a)
}


/** Fermat numbers **/
val ePrime = intArrayOf(3, 5, 17, 257, 65537)
