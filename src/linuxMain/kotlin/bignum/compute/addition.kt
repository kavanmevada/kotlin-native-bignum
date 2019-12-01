package bignum.compute

// Fastest Ever Achived in K/N
fun addition(str1: String, str2: String): String {
    // Which is big string
    val findBig = whichIsBig(str1, str2)

    val bigNum = findBig.first
    val smallNum = findBig.second

    val diff = bigNum.length - smallNum.length

    var add = 0
    var temp = ""

    for (i in bigNum.length - 1 downTo 0) {
        var ans = (bigNum[i] - '0') + add

        (i - diff).let {
            if (it >= 0) {
                ans += smallNum[it] - '0'
            }
        }

        add = 0

        (ans - 10).let {
            if (it >= 0) {
                temp = "$it$temp"
                add = 1
            } else temp = "$ans$temp"
        }
    }

    if (add != 0) temp = "$add$temp"

    return temp.cleaned()
}


//
//fun add(a: Int, b: Int): Int {
//    return if (b == 0) a else add(a xor b, a and b shl 1)
//}