package org.example.dataclass

data class DataClassSample(val name: String, val age: Int)

class NoDataClassSample(val name: String, val age: Int)

fun main() {
    val data1 = NoDataClassSample(name = "noeul", age = 23)
    val data2 = NoDataClassSample(name = "noeul", age = 23)

    println(data1.hashCode())
    println(data2.hashCode()) // data class가 아니면 hashCode가 다름

    // kotlin에서는 ==가 바로 equals()네!
    println(data1 == data2) // false -> 주소 비교기 때문에 false
    println(data1.toString())

    val date3 = DataClassSample(name = "RealNoeul", 23)
    val data4 = DataClassSample("RealNoeul", 23)

    println(date3.hashCode())
    println(data4.hashCode())

    println(date3 == data4) // true, data class가 eqauls() 오버라이딩~
    println(date3.toString())

}