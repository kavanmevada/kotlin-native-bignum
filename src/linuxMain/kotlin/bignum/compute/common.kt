package bignum.compute


fun String.cleaned(): String {
    return trimStart('0').let {
        if (it.length<=0) "0" else it
    }
}

fun makeEqualLenght(str1: String, str2: String, func: (String, String, Int) -> String): String {

    val len1 = str1.length
    val len2 = str2.length

    return when {
        len1 < len2 -> {
            func(str2, "0".repeat(len2 - len1) + str1, len2)
        }
        len1 > len2 -> {
            func(str1, "0".repeat(len1 - len2) + str2, len1)
        }
        else -> func(str1, str2, len1)
    }

}


//fun String.paddStart(padSize: Int){
//    var i = 0 ; var tmp: String? = null
//    while (i<=padSize) {
//        tmp = "0$this"
//        i++
//    }
//}


/**
 *  Find which number is big among them
 *
 *  First find length of both compare by its length
 *  If both same size compare each number from left in both strings
 *  bigger number makes biger sstring number
 * **/
fun whichIsBig(str1: String, str2: String): Pair<String, String> {
    val l1 = str1.length
    val l2 = str2.length

    when {
        l1 < l2 -> return (str2 to str1) //str2 is big
        l1 > l2 -> return (str1 to str2) //str1 is big

        else -> for (i in 0 until l1) {
            if (str1[i] - 0 > str2[i] - 0) return (str1 to str2) //str1 is big
            else if (str1[i] - 0 < str2[i] - 0) return (str2 to str1) //str2 is big
            else continue
        }
    }
    return (str1 to str2) //Both are equals
}