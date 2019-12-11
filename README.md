# Kotlin Native Big Numbers

![build](https://github.com/kavanmevada/kotlin-native-bignum/workflows/Build/badge.svg)

An Path object that may be used to locate a file in a file system. It will typically represent a system dependent file path.

**Defining Input Numbers**
Define input numbers as `String`
<div class="sample" markdown="1" theme="idea" data-highlight-only>

```kotlin
val num1 = "78046865754778456475475980547457679431345456585625135878908573463453465686956"  
val num2 = "6975654623458694534548780567435124346597806745345235346435324534565664356456568534565686567"
```
</div>

**Addition**
Result willbe  returned as `String`
<div class="sample" markdown="1" theme="idea" data-highlight-only>

```kotlin

val result = addition(num1, num2)
println(result)
Result: "6975654623458772581414535345891599822578354203024666691891910159701543265030031988031373523" 
 ```
</div>
 
**Substraction**
Result will be returned as `String`
<div class="sample" markdown="1" theme="idea" data-highlight-only>

```kotlin

val result = substraction(num1, num2)
println(result)
Result: "6975654623458616487683025788978648870617259287665804000978738909429785447883105081099999611"
 ```
</div>

**Multiplication**
Multiplication uses "Karatsuba Algorithm", result will be returned as `String`
<div class="sample" markdown="1" theme="idea" data-highlight-only>

```kotlin

val result = multiply(num1, num2)
println(result)
Result: "544427979948780395014337575473029265517077355742800524440302228778935731766132782249279951852943609042631843014153751431657177807472118352772633375657094811210436320052"
 ```
</div>

**Division**
Result will be returned as `String`
<div class="sample" markdown="1" theme="idea" data-highlight-only>

```kotlin

val result = divide(num2, num1) // First digit must be larger then second
println(result)
Result: "89377767524656"
 ```
</div>

**Modulo**
Result will be returned as `String`
<div class="sample" markdown="1" theme="idea" data-highlight-only>

```kotlin

val result = mod(num2, num1)
println(result)
Result: "70115625001303370593381915363770394634532119152551562080965903678733858099431"
 ```
</div>

**Mod Inverse**
Mod Inverse uses "Extended Euclid Algorithm", result will be returned as `String`
<div class="sample" markdown="1" theme="idea" data-highlight-only>

```kotlin

val a = "65537"
val m = "15166926664709716667942205393010561001948046930655516915962954857313795620516487420165145314674847016632910428541850885455208751754091856593720859678428300038169958374637870151540444491136118563716152917433640638540167202512723077277539513297837528211292408368640636807050066740641222119554707253152691400848501568174444017704890252120050024738716345450700365127964732618227829078048653931617963872233989434361163363978907267968992471699236848546273367345823624845717451894562839252947441335769348384749192736588371871150109884850152924857412343286027119085978105908844643816626934477827791704805246658776920099879968"
val result = modInverse(a, m)
println(result)
Result: "13262295594466022751877015494411648676909787226377095501824756305721679137356582458571554733174717457042314996543141259025918915067393106578213242986277836798867903696772394598079378861613097128810924748453082137919364051976694407579595600783666863439042587338170636030053529681034019195344944207950032593930529004491704889186477038592607332769300053538356742365202480005993289301855962446545167701086611113034395668088854216785923242987444742353804535796376313670652150933392017166923402362465997038082640159843597156110278883243171241662018846707849857537881613673469337980063776708132463482113527782390542139002721"
 ```
</div>

**Decimal to Binary**
result will be returned as `String`
<div class="sample" markdown="1" theme="idea" data-highlight-only>

```kotlin

val x = "15166926664709716667942205393010561001948046930655516915962954857313795620516487420165145314674847016632910428541850885455208751754091856593720859678428300038169958374637870151540444491136118563716152917433640638540167202512723077277539513297837528211292408368640636807050066740641222119554707253152691400848501568174444017704890252120050024738716345450700365127964732618227829078048653931617963872233989434361163363978907267968992471699236848546273367345823624845717451894562839252947441335769348384749192736588371871150109884850152924857412343286027119085978105908844643816626934477827791704805246658776920099879968"
val result = toBinary(x)
println(result)
Result: "1111000001001010010101111110111001111000001011101010111001001010101110001111101011101000110111111110001100010010111010001101010010101100101001000100111101101100010101101001111001100001001001001111100001001000000011111011011110001000011010110110100011000111001001010001000101000111101111101110010100010010100101101101101111010000101011010111010100000011010010001110001000010101000001010000111011110010111101100101010001111100101101010001100100000010110110010000000001001101011011100000000000100110111011010000100010001000011100010011000111111001010101110100011110001100111010000000001100011100100011010101101110010011010111101010011101001011110110101101100100110011100111011000011000001001110010001001001110110111011000011110001111000111100010010101001110101111000011110010011101111001000010100110101100010010110111001100111010000001100100101100101000001100010100111111000110000111010011000010011000101000111000100100001100110100010110011101010000010111111111100111110001100101100101111001001110000111000010101110010010011110011000010011001000000000001100100011101101101011010101000110011111011110101110000100000011111101001001110011101100011000010100101101001001001111001101110110011101111000010000110101110000001110110010011101010000111110100001111001101111010101101000101100001100111011001110111110011011111011100001111111110011100010110001110011001100001100000111000000000100010111110111101110011001111111100101101101001000011000101111100110111011111101100111010111111011101101001100011011110001101010000010111110001001101100010100001110100111011010101110101000000100011000111101010001001110111110010001000010001110001110111110000111110001001101110001100100001100011001010110101000000101101010111110010001101011110111100111000110010100010001001011001100001000100000010010100000000110110100100100111000101111010110001110111010111010110001111101010101110011101111110110101111000110111001011010110010011111100011010000100100111001000000000011101001100001011110100010101101000101000011000101111010100111010100110000010010011111111110111110000100000"
 ```
</div>

**Binary to Decimal**
It uses "Double Dabble Algorithm". It's fastest way to convert binary to decimal, result will be returned as `String`
<div class="sample" markdown="1" theme="idea" data-highlight-only>

```kotlin

val x = "1111000001001010010101111110111001111000001011101010111001001010101110001111101011101000110111111110001100010010111010001101010010101100101001000100111101101100010101101001111001100001001001001111100001001000000011111011011110001000011010110110100011000111001001010001000101000111101111101110010100010010100101101101101111010000101011010111010100000011010010001110001000010101000001010000111011110010111101100101010001111100101101010001100100000010110110010000000001001101011011100000000000100110111011010000100010001000011100010011000111111001010101110100011110001100111010000000001100011100100011010101101110010011010111101010011101001011110110101101100100110011100111011000011000001001110010001001001110110111011000011110001111000111100010010101001110101111000011110010011101111001000010100110101100010010110111001100111010000001100100101100101000001100010100111111000110000111010011000010011000101000111000100100001100110100010110011101010000010111111111100111110001100101100101111001001110000111000010101110010010011110011000010011001000000000001100100011101101101011010101000110011111011110101110000100000011111101001001110011101100011000010100101101001001001111001101110110011101111000010000110101110000001110110010011101010000111110100001111001101111010101101000101100001100111011001110111110011011111011100001111111110011100010110001110011001100001100000111000000000100010111110111101110011001111111100101101101001000011000101111100110111011111101100111010111111011101101001100011011110001101010000010111110001001101100010100001110100111011010101110101000000100011000111101010001001110111110010001000010001110001110111110000111110001001101110001100100001100011001010110101000000101101010111110010001101011110111100111000110010100010001001011001100001000100000010010100000000110110100100100111000101111010110001110111010111010110001111101010101110011101111110110101111000110111001011010110010011111100011010000100100111001000000000011101001100001011110100010101101000101000011000101111010100111010100110000010010011111111110111110000100000"
val result = binaryToDecimal(x)
println(result)
Result: "15166926664709716667942205393010561001948046930655516915962954857313795620516487420165145314674847016632910428541850885455208751754091856593720859678428300038169958374637870151540444491136118563716152917433640638540167202512723077277539513297837528211292408368640636807050066740641222119554707253152691400848501568174444017704890252120050024738716345450700365127964732618227829078048653931617963872233989434361163363978907267968992471699236848546273367345823624845717451894562839252947441335769348384749192736588371871150109884850152924857412343286027119085978105908844643816626934477827791704805246658776920099879968"
 ```
</div>

Note: Library is still under development.
