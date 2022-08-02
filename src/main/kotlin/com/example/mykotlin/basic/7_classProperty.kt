package com.example.mykotlin

//클래스는 Class 라는 키워드를 사용해서 만든다
//생성자를 만들때는 constructor 라는 키워드를 사용한다. constructor는 주로 생략한다.
class Coffee1 constructor (val name: String) {

}

//본문 내용이 없는 클래스를 만들수 있다.
class EmptyClass

// 클래스 프로퍼티 선언시 프로퍼티 간의 후행 쉼표를 사용할 수 있다.
class Coffee2 (
    val name: String,
    val price: Int, //마지막이여도 후행 쉼표 존재 가능
) {

}

// 프로퍼티는 val, var 둘다 사용 가능하며, 기본 값도 넣어 줄 수 있다.
class Coffee3 (
    var name: String = "",
    var price: Int = 0,
)


// custom getter/setter를 만들어보기
class Coffee4 (
    var name: String = "",
    var price: Int = 0,
    var iced: Boolean = false,
) {

    //커스텀 getter 예시
    //이렇게 val타입으로 프로퍼티를 만들면 setter는 안생기고 getter만 자동으로 생긴다
    val brand : String
        get() = "스타벅스"

    //아래 처럼 작성 할 수도 있다.
/*    val brand : String
        get()  {
            return "스타벅스"
        }*/


    //커스텀 setter예시
    //field는 식별자인데, 필드 참조에 접근하는데 사용되며 백킹 필드에 접근한다고 말한다. 여기서는 quantity를 의미
    //백킹 필드가 필요한 이유 ? 코틀린에서는 프로퍼티를 사용할때 setter를 사용하는데, 만약에 field가 아닌 프로퍼티를 직접 참조 하게 되면
    // 해당 프로퍼티가 setter로 인해 다시 자기를 참조하게 되여 무한 재귀 상태가 된다.
    var quantity : Int = 0
        set(value) {
            if(value > 0) {
                field = value
            }
        }
}


fun main() {

    //var로 선언된 키워드는 자동으로 getter, setter가 생성되기 때문에 프로퍼티에 접근하여 사용 가능
    val coffee = Coffee4()
    coffee.name = "아이스 아메리카노"
    coffee.price = 2000
    coffee.quantity = 1
    coffee.iced = true

    if(coffee.iced){ //프로퍼티로 상태를 나타낼 수 있기 때문에 객체 지향적이다. 자바에서는 메서드로 접근해서 가져와야함.
        println("아이스 커피")
    }

    print("${coffee.brand} ${coffee.name} ${coffee.quantity}개의 가격은 ${coffee.price}") //아이스 아메리카노 가격은 2000

}