package org.example.variable

class DataTypeSample2 {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            // Number Data Type
            val number1 = 123
            val number2 = 123L
            val number3 = -123
            val number4: Long = 123
            val number5: Any = 123
            val number6 = 123.456
            val number7: Double = 123.456
            val number8: Float = 123.456F

            // Logical Data Type
            val isTrue = true
            val isFalse: Boolean = false
            var isFalse2: Any = false // Any는 다 담기는구나! 완전 Object네!

            // Character, String Data Type
            val character = 'a'
            println(character)
            println(character + 1)

            val string1 = "hi"
            val string2: String = "hi"
            isFalse2 = "hi"
        }
    }
}