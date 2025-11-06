package org.example.function

class functionSample {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(sum1(1, 2))
            println(sum2(1, 2))
            noReturnFunction("return!")
            defaultParameter("It is not default")
            defaultParameter()
            namedArgument(b = "hi", c = "hello", a = "coco")
        }

        fun sum1(a: Int, b: Int): Int {
            return a + b
        }

        // return을 생략한 표현식 가능
        fun sum2(a: Int, b: Int) = a + b

        // 만약 리턴할 값이 없다면 return 타입을 Unit으로 정의할 수 있으며 생략 가능함
        // 코틀린에선 모든 함수가 리턴값을 다 가져야 하는데, 여태껏 Unit을 반환중이었고
        // 그걸 생략했던 거구나, 아래의 Unit 생략 가능!
        fun noReturnFunction(a: String) {
            println("called! $a")
        }

        // 전달 받는 파라미터는 기본 값을 사용 할 수 있다. 아래처럼 쓰면 자연스럽 오버로딩도 된다고 함
        fun defaultParameter(a: String = "default value") {
            println(a)
        }

        // 넘겨야 하는 값이 많을 경우 매개변수의 이름을 직접 명시하여 가독성을 높힐 수 있음
        // 대박이다! 순서 보장을 할 필요 없구나
        // 근데 순서 바꾸는 건 별로인 거 같고, 이름을 명시해주는 게 좋다. 가독성 올라갈듯
        fun namedArgument(a: String, b: String, c: String) {
            println("$a, $b, $c")
        }
    }
}