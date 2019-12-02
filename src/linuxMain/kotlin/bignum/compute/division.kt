package bignum.compute

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