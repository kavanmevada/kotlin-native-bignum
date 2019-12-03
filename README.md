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

val result = division(num2, num1) // First digit must be larger then second
println(result)
Result: "089377767524656"
 ```
</div>

Note: Library is still under development.
