package bignum.compute

// Returns modulo inverse of a with
// respect to m using extended Euclid
// Algorithm Assumption: a and m are
// coprimes, i.e., gcd(a, m) = 1
fun modInverse(_a: String, _m: String): String {
    var sign = 0
    var a = _a
    var m = _m
    val m0 = m
    var y = "0"
    var x = "1"
    //println("$a $m $m0 $y $x")
    if (m == "1") return "0"
    while (a.isGreater("1")) { // q is quotient
        val tmp = division(a, m)
        val q = tmp.first

        var t = m

        //println("$q $t")

        // m is remainder now, process same as Euclid's algo
        m = tmp.second
        a = t
        t = y

        //println("$m $a $t")

        // Update x and y
        val tmp2 = multiply(q, y)

        if (sign<0) y = addition(x, tmp2)
        else {
            if (tmp2.isGreater(x)) sign = -1
            y = substraction(x, tmp2)
        }

        x = t
    }

    // Make x positive
    if (sign<0) x = substraction(m0, x)
    return x
}


// A naive method to find modulor
// multiplicative inverse of 'a'
// under modulo 'm'
fun modInverse_old2(a: Int, m: Int): Int {
    var a = a
    a = a % m
    for (x in 1 until m) if (a * x % m == 1) return x
    return 1
}


fun modInverse_int(_a: Int, _m: Int): Int {
    var a = _a
    var m = _m
    val m0 = m
    var y = 0
    var x = 1
    //println("$a $m $m0 $y $x")
    if (m == 1) return 0
    while (a > 1) { // q is quotient
        val q = a / m
        var t = m

        //println("$q $t")

        // m is remainder now, process same as Euclid's algo
        m = a % m
        a = t
        t = y

        //println("$m $a $t")

        // Update x and y
        y = x - q * y
        x = t
    }

    // Make x positive
    if (x < 0) x += m0
    return x
}
