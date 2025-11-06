package org.example.inheritance

open class Car(val name: String, val price: Double, val brand: String) {
    fun introduce() {
        println("this car is $name. this made by $brand")
    }

    fun howMuch() {
        println("this car is $price dollars")
    }

    open fun myPurchaseDate() {
        println("you don't buy yet")
    }
}