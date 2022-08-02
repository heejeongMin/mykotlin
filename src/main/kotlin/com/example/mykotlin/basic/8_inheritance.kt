
//자바의 모든 클래스의 조상은 Object이고 코틀린은 Any 이다.
//코틀린의 클래스는 자바와 다르게 기본적으로 final클래스로, 기본적으로 상속을 막고 있다.
//필요한 경우 open이라는 키워드를 사용하여 상속을 허용할 수 있다.
/*
 public open class Any {
    public open operator fun equals(other: Any?): Boolean
    public open fun hashCode(): Int
    public open fun toString(): String
 */

//open 키워드를 사용하여 상속이 가능한 상태로 만듬
//함수, 프로퍼티르르 재정의할 때도 open 키워드를 사용한다.
open class Dog {
    open var age : Int = 0

    open fun bark() {
        println("멍멍")
    }
}

//상속하려면 콜론 뒤에 상위 클래스를 명시한다.
class Bulldog : Dog() {

    //프로퍼티, 함수를 재정의할때 override 키워드를 사용해주어야 한다.
    override var age : Int = 0

    override fun bark() {
        println("컹컹")
    }
}

//코틀린에서는 기본 생성자를 사용하면 프로퍼티/함수를 더 간결하게 재정의 할 수 있다.
open class Dachshund(final override var age : Int = 0): Dog() {

    //override가 되면 자동으로 오픈 상태가 된다.
    override fun bark() {
        println("멍~")
    }
}

//프로퍼티/함수에 open이 없어도 재정의 할 수 있는것을 볼 수 있다.
//만일 재정의 할 수 없게 막아야하는 경우라면 파이널을 사용한다.
class panchoTheDacshund : Dachshund() {
//    override var age : Int = 0

    //하위 클래스에서 상위클래스에 접근하려면 자바처럼 super를 사용하면 된다.
    override fun bark() {
        super.bark()
    }
}

//추상 클래스를 구현할 때는 abstract 키워드를 사용하면 된다
abstract class Developer {
    abstract var age: Int
    abstract fun code(language: String)
}

//자바와 마친가지로 abstract로 된 프로퍼티와 함수는 구현해주어야 한다.
class BackendDeveloper(override var age: Int) : Developer() {

    override fun code(language: String) {
        println("I code with $language")
    }
}


fun main(){

    val dog = Dachshund(age = 2)
    println(dog.age)
    dog.bark()

    val backendDeveloper = BackendDeveloper(3)
    println(backendDeveloper.age)
    backendDeveloper.code("kotlin")

}