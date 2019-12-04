package bignum.compute

fun division(x: String, y: String) : Pair<String, String> {

    val pieceSize = y.length


    if (y.isGreater(x)) return "0" to x
    else if (x == "0") return "0" to "0"
    //TODO implement throw error on "num/0"


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
                    remainder = sub.cleaned()
                }

                break
            }
        }
    }

    //println("quo:$quo rem:$remainder")
    return quo.cleaned() to remainder
}


fun divide(x: String, y: String) = division(x, y).first
fun mod(x: String, y: String) = division(x, y).second