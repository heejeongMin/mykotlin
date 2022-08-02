package com.example.mykotlin.advance//클래스를 상속하거나 데코링터 패턴을 사용하지 않아도 클래스를 확장할 수 있는 기능을 제공한다.
//확장기능이라고 부름

//스트링 클래스를 확장하는 기능을 사용해 보겠음
//확장의 대상이 되는 함수를 적고, 점 뒤에 기능을 넣어준다
//수신자 객체 (receiver) : this는 확장이 되는 대상의 객체 잠조
fun String.first() : Char {
    return this[0]
}

fun String.addFirst(char : Char) : String {
    return char + this.substring(0)
}

//확장함수를 사용시 주의할점
//활장하는 클래스의 동일의 시그니쳐의 함수 가 있는 경우 클레이스에 있는 함수가 우선순위를 가진다.
class MyExample {
    fun printMessage() = println("클래스 출력")
}

fun MyExample.printMessage() = println("확장 출력") //기존에 동일한 시그니쳐의 함수가 클래스 안에 존재해도 확장은 할 수 있지만 (컴파일에러안남) 얘가 실행되지는 않는다.
fun MyExample.printMessage(message : String) = println("${message} 확장 출력")

//널가능성이 있는 클래스의 확장 기능
//내부에서 널 체크를 할 수 있음
//MyExample이 null이 올수 있다고 가정하고 안전연산자를 사용하여 준다.
fun MyExample?.printNullOrNotNull() {
    if( this == null ) println("널인 경우에만 출력")
    else println("널이 아닌 경우에만 출력")
}

fun main () {
    println("ABCD".first()) //A

    println("ABCD".addFirst('Z')) //ZABCD

    MyExample().printMessage() // 클래스 출력
    MyExample().printMessage("진짜") // 진짜 확장 출력



    var myExample: MyExample? = null
    //myExample을 안전 연산자 없이 바로 사용할 수 있는 이유는 ???
    //확장함수 내부에서 null체크를 이미 하고 있기 때문에 컴파일러가 NPE 가 발생하지 않는다는 것을 알기 때문
    myExample.printNullOrNotNull() // 널인 경우에만 출력

    myExample = MyExample()
    myExample.printNullOrNotNull() // 널이 아닌 경우에만 출력

}

