package bignum

import bignum.compute.divideByTwo
import bignum.compute.multiply
import kotlin.system.measureNanoTime


fun hello(): String = "Hello, Kotlin/Native!"


fun main() {
    println(hello())


//    val binary = toBinary("15166926664709716667942205393010561001948046930655516915962954857313795620516487420165145314674847016632910428541850885455208751754091856593720859678428300038169958374637870151540444491136118563716152917433640638540167202512723077277539513297837528211292408368640636807050066740641222119554707253152691400848501568174444017704890252120050024738716345450700365127964732618227829078048653931617963872233989434361163363978907267968992471699236848546273367345823624845717451894562839252947441335769348384749192736588371871150109884850152924857412343286027119085978105908844643816626934477827791704805246658776920099879968")
//
//    var addition = binary.length
//    var i = 0
//    while (i < binary.length) {
//        println(addition)
//
//        val char = binary[i]
//        addition--
//        i++
//        for (j in i until binary.length) {
//            if (binary[j] == char) {
//                addition--
//                i++
//            } else break
//        }
//    }




//    val a = "65537"
//    val m = "15166926664709716667942205393010561001948046930655516915962954857313795620516487420165145314674847016632910428541850885455208751754091856593720859678428300038169958374637870151540444491136118563716152917433640638540167202512723077277539513297837528211292408368640636807050066740641222119554707253152691400848501568174444017704890252120050024738716345450700365127964732618227829078048653931617963872233989434361163363978907267968992471699236848546273367345823624845717451894562839252947441335769348384749192736588371871150109884850152924857412343286027119085978105908844643816626934477827791704805246658776920099879968"
//    println(modInverse(a, m))




    //println(multiply(MOD, MOD))
    //println(powerMod())


}













fun pow(base: String, power: Int): String {
    var result = base

    var pow = (power/2)-1
    while (pow > 0) {
        result = multiply(result, base)
        pow--
    }
    result = multiply(result, result)

    if (power%2!=0) result = multiply(result, base)

    return result
}




fun toBinary(num: String): String {
    var ans = ""
    var tmp = num
    while (tmp != "0"){
        tmp.last().let {
            if (it == '0' || it == '2' || it == '4' || it == '6' || it == '8') {
                ans = "0$ans"
            } else ans = "1$ans"
        }
        tmp = divideByTwo(tmp)
    }
    return ans
}



























//fun powerMod() {
//    //var length = 0
//    var num = d
//    var binOut = ""
//
//    while (true) {
//        var quo = ""
//        var rem = (num[0]-'0')
//
//        for (i in num.indices) {
//            val p = rem / 2
//
//            if (p != 0) quo += p
//            else if (p == 0 && i > 0) quo += p
//
//            rem = if (i + 1 != num.length) {
//                // substract and if it 0 bring number from top
//                (num[i]-'0') % 2 * 10 + (num[i+1]-'0')
//            } else rem % 2 // Is is last iteration
//        }
//
//        //length++
//        binOut = "$rem$binOut"
//
//        //------------
//
//
//        //println(rem)
//
//        //---------------------
//
//        if (quo == "1") {
//            binOut = "$quo$binOut"
//
//            //length++
//            break
//        }
//
//        num = quo
//    }
//
//    println("Ans: $binOut")
//
//
//    val base = m
//    val exponent = "1"
//    var ans = ""
//    var k = "1"
//
//
//    ans = multiply(base, base)
//
//    binOut.forEachIndexed { index, c ->
//        if (index>1) {
//            ans = multiply(ans, ans)
//            //ans = division(ans, MOD).second
//            println(ans)
//            ans = mod(ans, MOD)
//            if (ans.isGreater(MOD)) println("isGreater")
//            //if (c == '1') k = multiply(ans, k)
//        }
//
//        println(index)
//    }
//
//    //ans = mod(k, MOD)
//
//
//    println("Kavan: $ans")
//}



















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