package bignum.compute

import platform.posix.gid_t

/**
 *  Karatsuba Method
 *  Fastest known multiplication algorithm
 * **/
fun multiply3(str1: String, str2: String): String {

    return if (str1.length == 1 && str1[0] == '0') {
        "0"
    } else if (str2.length == 1 && str2[0] == '0') {
        "0"
    } else if (str1.length == 1 && str2.length == 1) {
        "${(str1[0] - '0') * (str2[0] - '0')}"
    } else makeEqualLenght(str1, str2) { first, second, length ->

        val fh = length / 2 // First half of string, floor(n/2)
        //val sh = length - fh // Second half of string, ceil(n/2)

        // Find the first half and second half of first string.
        val Xl = first.substring(0, fh)
        val Xr = first.substring(fh, length)

        // Find the first half and second half of first string.
        val Yl = second.substring(0, fh)
        val Yr = second.substring(fh, length)

        // Recursively calculate the three products of inputs of size n/2
        var P1 = multiply(Xl, Yl)// + "0".repeat(2*fh)

        val P2 = multiply(Xr, Yr)// + "0".repeat(fh-1)

        val P3 = multiply(addition(Xl, Xr), addition(Yl, Yr))

        val P4 = substraction(substraction(P3, P2), P1) + "0".repeat(fh)

        P1 += "0".repeat(2 * fh)

        val temp3 = addition(addition(P1, P4), P2)

        temp3.trimStart('0')
    }
}





fun multiply(str1: String, str2: String): String {
    //println("----------- str1:$str1 str2:$str2 -----------")

    // Find Big Num length
    val l1 = str1.length
    val l2 = str2.length

    if (l1==1 && l2==1) {
        return if (str1[0]=='0' || str2[0] == '0') "0"
        else "${(str1[0]-'0')*(str2[0]-'0')}"
    } else {
        val getBig = if (l1 > l2) str1 to str2 else str2 to str1

        var big = getBig.first
        var small = getBig.second
        var bigL = big.length
        val smallL = small.length


        /**  Add padding **/
        // If big number length is odd then add 0 to right
        // to make it even length and update
        // big numberlength
        if (bigL%2!=0) { bigL+=1; big = "0"+big }

        // Add padding to small number to match size with big
        // number
        small = "0".repeat(bigL-smallL)+small

        val N = bigL
        val k = N/2

        // Make break
        val a = big.substring(0, k)
        val b = big.substring(k, N)

        val c = small.substring(0, k)
        val d = small.substring(k, N)


        val ac = multiply(a, c)
        //println("a:$a c:$c = ac:$ac")

        val bd = multiply(b, d)
        //println("b:$b d:$d = bd:$bd")

        val plus1 = addition(a, b) // a+b
        //println("plus1:$plus1")

        val plus2 = addition(c, d) // c+d
        //println("plus2:$plus2")

        val P3 = multiply(plus1, plus2)
        //println("P3:$P3")

        val P4 = substraction(substraction(P3, ac), bd)
        //println("P4:$P4")


        val first = ac + "0".repeat(2*k)
        val mid = P4 + "0".repeat(k)
        val last = bd

        //println("first:$first mid:$mid last:$last")


        val ans = addition(addition(first, mid), last)

        //println("ans:$ans")

        return ans.cleaned()

    }

}






























/**
 *  School Method Algorithm
 * **/
fun multiply_old(str1: String, str2: String): String {

    // Which is big string
    val findBig = whichIsBig(str1, str2)
    val bigNum = findBig.first
    var smallNum = findBig.second


    val addition = mutableListOf<String>()
    for (i in 0..smallNum.length - 1) {
        var temp = ""
        var add = 0
        for (j in bigNum.length - 1 downTo 0) {
            val ans = ((smallNum[i] - '0') * (bigNum[j] - '0') + add).toString()
            add = 0
            if (ans.length > 1) {
                temp += ans[1]
                add = (ans[0] - '0')
            } else temp += ans
        }
        if (add != 0) temp += add

        val final = "${temp.reversed()}${("0".repeat(smallNum.length - 1 - i))}"
        addition.add(final)
    }

    var temp = addition[0]
    for (i in 1..addition.size - 1) {
        temp = addition(temp, addition[i])
    }


    return temp
}