package org.example.constructor

class PersonWithConstructor constructor(private val name: String, private val age: Int) { // 주 생성자

    private var etc: String = "no value"

    init {
        println("Initializer block: $etc")
    }

    constructor(name: String) : this(name, 15) // 부 생성자
    
    // public Person(String name) {
    //this(name, 15);
    //} 자바 였으면 원래 이렇게 해야할텐데, 코틀린은 바로 :로 짧게 표현 가능하네!
    constructor(name: String, age: Int, etc: String) : this(name, age) { // 추가 생성자
        this.etc = etc
        println("additional constructor is called ${this.etc}")
    }

    fun sayHello() {
        println("Hello!")
    }

    fun introduce() {
        print("$name ")
        print("$age ")
        println(etc)
    }
}