package org.example.variable

class DataTypeSample {

    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            val name: String = "문자열임을 알아서 타입 추론하기에, String 생략 가능. IDE도 회색으로 칠하네!"
            var hello = "생략하는 게 매우 어색하네.. 이래도 되는건가? 마우스를 올려놓으면 String이라고 IDE가 알려주네"
            var age = 12
            // name = "val은 재할당 불가! final 키워드가 내포되어 있구나"
            age = 15 // var은 재할당 가능

            println("my name is $name")
            println("hello is $hello")
            println("my age is $age")

        }
    }
}