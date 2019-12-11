package bignum.compute

//TODO implement any fast algorithm like barrett or newton's
fun division_school(x: String, y: String) : Pair<String, String> {

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


fun divide(x: String, y: String) = division_school(x, y).first
fun mod(x: String, y: String) = division_school(x, y).second



fun divideByTwo(num: String): String {
    var additive = 0
    var answer = ""

    num.forEach {
        val div = (it -'0') / 2 + additive
        answer += div
        if (it == '1' || it == '3' || it == '5' || it == '7' || it == '9'){
            additive = 5
        } else additive = 0
    }

    return answer.cleaned()
}