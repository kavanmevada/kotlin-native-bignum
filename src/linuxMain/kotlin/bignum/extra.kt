package bignum


// Gives number without leading Zeros
fun compareTo(x: String, y: String): Int {
    var xIndex = 0
    var yIndex = 0

    while (xIndex != x.length && x[xIndex] =='0') {
        xIndex++ // If first char is '0' then it will update starting point to next
    }

    while (yIndex != y.length && y[yIndex] == '0') {
        yIndex++
    }

    return compareNotLeadingZeros(xIndex, x, yIndex, y)
}

fun compareNotLeadingZeros(_xIndex: Int, x: String, _yIndex: Int, y: String): Int {
    var xIndex = _xIndex
    var yIndex = _yIndex

    val diff = x.length - y.length

    if (diff != 0) return if (diff<0) -1 else 1

    // Length of magnitudes are same, test magnitude values
    while (xIndex < x.length) {
        val v1 = x[xIndex++]
        val v2 = y[yIndex++]

        if (v1!=v2) return if(v1<v2) -1 else 1
    }

    return 0
}




fun toBinaryString(x: String): String {

    //var length = 0
    var num = x
    var binOut = ""

    while (true) {
        var quo = ""
        var rem = (num[0]-'0')

        for (i in num.indices) {
            val p = rem / 2

            if (p != 0) quo += p
            else if (p == 0 && i > 0) quo += p

            rem = if (i + 1 != num.length) {
                // substract and if it 0 bring number from top
                (num[i]-'0') % 2 * 10 + (num[i+1]-'0')
            } else rem % 2 // Is is last iteration
        }

        //length++
        binOut = "$rem$binOut"

        if (quo == "1") {
            binOut = "$quo$binOut"
            //length++
            break
        }

        num = quo
    }

    return binOut
}





