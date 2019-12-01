package bignum

import bignum.compute.addition
import bignum.compute.multiply
import bignum.compute.substraction
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SampleTests {
    val num1 = "78046865754778456475475980547457679431345456585625135878908573463453465686956"
    val num2 = "6975654623458694534548780567435124346597806745345235346435324534565664356456568534565686567"

    @Test
    fun testAddition() {
        val result = addition(num1, num2)
        val realAns = "6975654623458772581414535345891599822578354203024666691891910159701543265030031988031373523"
        assertEquals(result, realAns)
    }

    @Test
    fun testSubstraction() {
        val result = substraction(num1, num2)
        val realAns = "6975654623458616487683025788978648870617259287665804000978738909429785447883105081099999611"
        assertEquals(result, realAns)
    }

    @Test
    fun testMultiplication() {
        val result = multiply(num1, num2)
        val realAns = "544427979948780395014337575473029265517077355742800524440302228778935731766132782249279951852943609042631843014153751431657177807472118352772633375657094811210436320052"
        assertEquals(result, realAns)
    }
}