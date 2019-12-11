package bignum.compute

fun binaryToDecimal(num: String): String {
    var binary = num

    val len = num.length

    (0 until 4*(if (len%4==0) len/4 else len/4+1)-1).forEach {

        binary = binary.trimStart('0')+"0".repeat(1) //shift 1


        binary = (if (binary.length%4!=0) "0".repeat(4-(binary.length%4)) else "")+binary


        var tmp0 = ""
        val tmp1 = binary.length - 4*(if (len%4==0) len/4 else len/4+1)

        for(i in binary.indices step 4) {
            val s = "${binary[i]}${binary[i+1]}${binary[i+2]}${binary[i+3]}"

            if (i < tmp1) {
                tmp0 += when (s) {
                    "0111" -> "1010"
                    "0101" -> "1000"
                    "0110" -> "1001"
                    "1000" -> "1011"
                    "1001" -> "1100"
                    "1010" -> "1101"
                    "1011" -> "1110"
                    "1100" -> "1111"
                    "1101" -> "10000"
                    "1110" -> "10001"
                    "1111" -> "10010"
                    else -> s
                }
            } else tmp0 += s

        }

        binary = tmp0
    }

    binary += "0".repeat(1) //shift 1

    binary = if (binary.length%4!=0) "0".repeat(4-(binary.length%4))+binary else binary


    var tmp0 = ""
    val tmp1 = binary.length - 4*(if (len%4==0) len/4 else len/4+1)

    for(i in 0 until tmp1 step 4) {
        tmp0 += when ("${binary[i]}${binary[i+1]}${binary[i+2]}${binary[i+3]}") {
            "0000" -> 0
            "0001" -> 1
            "0010" -> 2
            "0011" -> 3
            "0100" -> 4
            "0101" -> 5
            "0110" -> 6
            "0111" -> 7
            "1000" -> 8
            "1001" -> 9
            else -> null
        }
    }

    return tmp0
}


fun powOfTwo(num: Int) = binaryToDecimal("1"+"0".repeat(num))