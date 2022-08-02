//함수형 프로그래밍이란
//수학의 함수적 개념을 참고해 만든 패러다임의 하나로 깔끔하고 유지보수 가 용이한 소프트웨어를 만들기 위해서 함수를 사용한다.
//함수형 패러다임은 부수효과가 없고 똑같은 인풋이 들어오는 경우 동일한 값을 리턴한다.
//람다, 고차함수, 쿼리, 메모리제이션 등을 포함한다.
//코르린에서 어떻게 함수형 패러다임을 지원하는지 알아보자

//함수는 일급객체로 분류된다.
// 인자로 넘기거나, 변수에 대입하거나, 값으로 반환하거나 할 수 있다.
//함수의 타입을 선언할때는 () -> 표기하고, Unit은 함수가 반환하는 타입이 Unit이라는 뜻
//String 을 반호나하는 함수 였단면 반환타입이 Unit이 아니라 String 이고 실제로도 스트링을 반환하겠지
val func : () -> Unit = {}

//함수를 데이터 구조에도 저장이 그낭하다
val printHello : () -> Unit = { println("Hello")}
fun printHello2() {
}

//함수를 인자로 받아 실행하는 함수
fun call(block: () -> Unit) {
    block()
}

fun printNo() = println("No!")

//(함수의 인자값 타입) -> 반환타입 = {인자명 : 인자타입 -> println(인자값)}
val printMessage : (String) -> Unit = { message : String -> println(message)}
//줄여보기 : 이미 인자값 타입이 String으로 되어 있기 때문에 바디에서 다시 정의해주지 않아도 됨
val printMessage2 : (String) -> Unit = { message  -> println(message)}
//줄여보기 2 : 인자를 가리키는 리시버객체인 소프트키워드 it을 사용할 수 있다
val printMessage3 : (String) -> Unit = { println(it)}


//다수의 인자값을 받아서 결과값을 리턴하는 함수
val plus : (Int, Int) -> Int = { a, b -> a + b }

//고차함수 : 함수를 인자로 받아서 결과처리, 반환하는 함수를 고차함수  라고 부른다.
fun forEachStr(collection: Collection<String>, action : (String) -> Unit) {
    for(item in collection) {
        action(item)
    }
}


fun main () {

    val list = mutableListOf(printHello) // 함수도 값이기 때문에 변수에 넣을 수 있다.
    list[0]() //Hello 저잗된 요소에 접근하여 함수 호출

    val func : () -> Unit = list[0]
    func() // Hello  다시 변수에 저장해서 할 수도 있다.

    call(printHello) //Hello 인자로 넘겨서 호출도 가능하다

    //func으로 선언한 함수로 선언을 하면 일급객체가 되지 않기 때문에 컴파일 오류가 발생하는 것이다.
/*
    val list2 = mutableListOf(printNo) // 컴파일 오류가 난다.
    call(printNo) //컴파일 오류가 난다.
    val func2 = printNo
  */

    //다수의 인자값을 받아서 결과값을 리턴하는 함수
    val result = plus (1, 2)
    println(result) // 3


    //고차함수 예시
    val list3 = listOf("a", "b", "c")
    val printStr : (String) -> Unit = { println(it) }

    forEachStr(list3, printStr) // a, b, c
    forEachStr(list3) {
        println(it)
    }


    list3.forEach(printStr) //a, b, c 코틀린에서 제공하는 forEach도 고차함수이기때문에 가능
    list3.forEach {
        println(it.length) // 1, 1,1
    }

    list3.filter {
        it == "a"
    }.forEach {
        println(it) // a
    }


    var upperCase : (String) -> String = {it.uppercase()}
    println(list3.map(upperCase)) // [A, B, C]



    outerFunc() // 그냥 이렇게 접근하면 아무것도 출력이 되지 않는다. 이유는 outerFunc를 호출한것이고, 그 안에 있는 익명함수를 호출한것은 아니기 때문이다.
    outerFunc()() //이것은 익명함수! 안에 있는 익명함수를 호출하려면 이렇ㄱ ㅔ사용

    val noNameFunc = outerFunc()
    noNameFunc() // 이것은 익명함수!


    val callReference : () -> Unit = { printHello() }
    callReference() //Hello

    //위 코드를 람다 레퍼런스로 호출하면 이렇게 작성할 수 있고 내부까지 호출해주어야하니 ()()를 사용한다.
    val callReference2 = ::printHello
    callReference2()() // Hello

    val numberList = listOf("1", "2", "3")
    numberList
        .map{ it.toInt() }
        .forEach{ println(it) } // 1 2 3

    //위 코드를 람다 레퍼런스로 호출
    numberList
        .map(String::toInt)
        .forEach(::println) // 1 2 3

}

//익명함수
// 이름이 없는 함수를  익명함수라고 한다.
fun outerFunc() : () -> Unit {
    return fun() { //리턴값에 함수가 있는데 이름이 없다.
        println("이것은 익명함수!")
    }
}

//람다식
//outerFunc의 익명함수 를 람다 함수로 변경
fun outerFunc2() : () -> Unit {
    return {
        println("이것은 익명함수!")
    }
}
// 더 줄이기
fun outerFunc3() : () -> Unit = { println("이것은 익명함수!") }

//람다 표현식 전체
val sum : (Int, Int) -> Int = { x: Int, y: Int -> x + y }
// 줄이기
val sum2 = {x : Int, y: Int -> x + y}


