package org.example.constructor

class ClassSample {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val person1 = PersonWithConstructor("Person1", 15)
            val person2 = PersonWithConstructor("Person2")
            val person3 = PersonWithConstructor("Person3", 20, "추가값")

            person1.sayHello()
            person1.introduce()
            person2.sayHello()
            person2.introduce()
            person3.sayHello()
            person3.introduce()

        }
    }
}