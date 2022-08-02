class MyGenerics<T>(val t: T) {

}

fun main() {

    //제네릭을 사용한 클래스의 인스턴스를 만들려면 타입알규먼트를 제공
    //타입알규먼트는 생서자의 값으로 추론이 가능할때는 생략이 가능하다.
    /*val generics = MyGenerics<String>("테스트")*/
    val generics = MyGenerics("테스트")

    //변수의 타입에 제네릭을 사용하는 경우
    var list1 : MutableList<String> = mutableListOf()

    //타입아규먼트를 생성자에서 추가
    val list2 = mutableListOf<String>()

    //타입을 모를경우 *를 사용할 수 있다.
    val list3 : List<*> = listOf<String>("테스트")
    var list4 : List<*> = listOf<Int>(1,2,3,4)

    //변셩 : 제네릭에서 핵심적인 기능으로, 제네릭에서 파라미터화된 타입이 서로 어떤 관계에 있는지 설명
    //공변셩, 반공변셩, 무공변셩 이 존재한다.
    //PECS : producer는 extends, consumer는 super <- 변성을 선택할시
    //공변성은 자바 제네릭의 extends를 사용한다. 코틀린에서는 out을 사용
    //반공변성은 자바 제네릭의 super 사용, 코틀린에서는 in 을 사용

    //컴파일 에러가 난다. 스트링을 제네릭으로 받게 되어있는데 실수로 String이 아닌것이 들어가면 ClassCastException이 날 수 있기 때문
 /*   val charGenerics = MyGenerics<CharSequence> = generics */

    //공변성을 도입해서 상위와 하위 클래스 간에 조합이 가능할 수 있도록 한다
    //제네릭에 out을 사용. CharSequence가 String의 상위 타입이기때문에 가능
    //값을 사용하기 때문에 producer
    val theGenerics = TheGenerics<String>("테스트")
    val charGenerics : TheGenerics<CharSequence> = theGenerics


    //반공변성을 사용. 소비하는 측이기때문에 to에 in을 넣어준다
    val bag = Bag<String>()
    bag.saveAll(mutableListOf<CharSequence>("1", "2"), mutableListOf<String>("3", "4"))

}

//공변성을 도입해서 상위와 하위 클래스 간에 조합이 가능할 수 있도록 한다
class TheGenerics<out T>(val t : T)


class Bag<T> {

    fun saveAll(
        to: MutableList<in T>, //반공변성
        from: MutableList<T> //무공변성 서로 관계가 없어서
    ) {
        to.addAll(from)
    }
}