package com.example.mykotlin.advance

import java.time.LocalDateTime

// object 키워드를 사용한다. 해당 키워드를 사용하면 싱글톤 객체를 생성할 수 있따.
// 보통 유틸리티성으로 많이 사용한다.
object Singleton {
    //싱글톤 객체 안에서 변수/함수 를 만들때는 클래스 한정자를 사용한다.

    val a = 1234

    fun printA() = println(a)

}

object DateTimeUtils {
    val now : LocalDateTime
        get() = LocalDateTime.now()
    
    const val DEFAULT_FORMAT = "YYYY-MM-DD" //const 키워드는 자바의 상수 생성과 유사핟. 
    
    fun same(a : LocalDateTime, b : LocalDateTime) : Boolean {
        return a == b
    }
}

//동반객체를 만들때에는 companion object 라는 키워드를 사용하며 클래스 안에 정의한다.
class MyClass {

    private constructor()

    companion object MyCompanion { //동반객체에 이름을 붙일수도 있고, 안 붙일수도 있다. MyCompanion생략 가능
        val a = 1234
        fun newInstance() = MyClass() //com.example.mykotlin.advance.MyClass 가 직접 생성자로 생성하지 못하게 하기 윔
    }

}

fun main() {

    //싱글톤 사용
    println(Singleton.a) // 1234
    Singleton.printA() // 1234
    
    println(DateTimeUtils.now) // 2022-07-29T11:49:26.035592
    println(DateTimeUtils.now) //2022-07-29T11:49:26.039135
    println(DateTimeUtils.now) // 2022-07-29T11:49:26.039200

    println(DateTimeUtils.DEFAULT_FORMAT) // YYYY-MM-DD

    val now = LocalDateTime.now()

    println(DateTimeUtils.same(now, now)) //true

    //동반객체 사용. 클래스 한정자로 사용할 수도 잇고
    println(MyClass.a) // 1234
    println(MyClass.newInstance()) //com.example.mykotlin.advance.MyClass@214c265e

    //Companion키워드를 넣을수도 있지만 생략이 가능함으로 굳이 사용할 필요는 없다
/*
    println(com.example.mykotlin.advance.MyClass.Companion.a)
    println(com.example.mykotlin.advance.MyClass.Companion.newInstance())
*/

    //companion객체에 이름이 있는 경우 이름을 적어주어야하지만 이역시 생략 가능하다
    println(MyClass.a)
    println(MyClass.newInstance())
}