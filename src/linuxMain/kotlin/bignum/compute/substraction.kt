package bignum.compute


fun substraction(str1: String, str2: String): String {
    // Which is big string
    val findBig = whichIsBig(str1, str2)

    val bigNum = findBig.first
    val smallNum = findBig.second

    val diff = bigNum.length - smallNum.length

    var carry = 0
    var temp = ""

    for (i in bigNum.length - 1 downTo 0) {

        var ans = (bigNum[i] - '0')

        (i - diff).let {
            if (it >= 0) {
                ans -= (smallNum[it] - '0')
            }
        }

        ans -= carry

        carry = 0

        if (ans < 0) {
            temp = "${10 + ans}$temp"
            carry = 1
        } else temp = "$ans$temp"

    }

    return temp.cleaned()
}
