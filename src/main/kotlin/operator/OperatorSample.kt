package org.example.operator

class OperatorSample {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val a = 3 / 2 // -> 1
            val b = 3.0 / 2 // -> 1.5
            val c = 1 / 3 // -> 0
            val d = 1.0 / 3 // -> 0.3333333333333333

            println(a)
            println(b)
            println(c)
            println(d)

        }
    }

}