package com.example.mykotlin

//데이터 클래스는 데이터를 보관하거나 전달하기 위한 용도 이다. DTO같은 역할
//data라는 키워드를 사용하여 생서한다.
//data를 사용하면 equals, hasCode, toString, copy등을 자동으로 만들어준다. 자바도 jdk15 부터는 record라는 키워드를 사용하면 유사하게 사용하가능하다
data class Person (val name : String, val age: Int)


//일반 클래스인 경우는 equals, hasCode 등을 직접 구현을 해주면 된다
class JustPerson(val name:String, val age: Int)


fun main (){

    // equals 인스턴스의 동등성 비교
    val justPerson1 = JustPerson(name = "tony", age = 12)
    val justPerson2 = JustPerson(name ="tony", age = 12)

    println(justPerson1 == justPerson2) //false
    println(justPerson1.toString()) // com.example.mykotlin.JustPerson@4c873330


    val person1 = Person(name = "tony", age = 12)
    val person2 = Person(name ="tony", age = 12)

    println(person1 == person2) //true
    println(person1.toString()) //Person(name=tony, age=12)

    //data 클래스의 copy는 객체의 불변성을 쉽게 보장할 수 있다.
    //불변성이 깨졌을때의 문제점은
        //hash 계열 자료 구조에서 의도치 않은 오류가 발생할 수 있다.
        //멀티스레드 환경에서 문제가 발생할 수 있다.
    //copy를 사용하여 불변성을 보장하거나, 복사하면서 원하는 값을 바꿔서 복사할 수 도 있다.

    val person3 = person1.copy()
    val person4 = person1.copy(name = "strange")

    println(person3) // Person(name=tony, age=12)
    println(person4) // Person(name=strange, age=12)

    //componentN
    //컴포넌트가 늘아나기때문에 N이라고 표현한다. 순새대로 가지고 오는 경우
    println("이름=${person1.component1()}, 나이=${person1.component2()}")

    //구조분해 할당
    val (name, age) = person1 // 얘가 구조분해할당 문법
    println("이름 ${name}, 나이 ${age}")
}