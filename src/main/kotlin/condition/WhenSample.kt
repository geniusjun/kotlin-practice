package org.example.condition

import kotlin.random.Random

class WhenSample {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = Random.nextInt(10)
            val b = Random.nextInt(10)

            when (a) {
                1, 2 -> println("a is 1 or 2")
                3 -> println("a is 3")
                4 -> println("a is 4")
                5 -> println("a is 5")
                in 6..8 -> println("a is in 6,7,8")
                else -> println("a is $a")
            }

            when {
                a > b -> println("a > b")
                else -> println("a <= b")
            }


        }
    }
}