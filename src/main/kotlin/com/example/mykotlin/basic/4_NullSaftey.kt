fun main() {

    //코틀린에는 null을 받을 수 없는 타입이 있다.
    //null을 100% 제거할 수 없는 이유는 자바와의 호환도 있고 DB에 null이 있기 때문이다.
/*    val a : String = null //a 에 null로 초기화하려고 하면 컴파일 오류가 난다.
    var b : String : "aabbcc"
    b = null // b 에 null을 재할당 하려고 해도 컴파일 오류가 난다 */

    //nullable 타입
    //타입 뒤에 물음표를 (안전 연산자) 붙여 코틀린 컴파일러에게 nullable 하다고 알려줌
    var a : String? = null
//    a.length // nullable한 객체에게 접근하면 컴파일 오류가 난다.
    //변수 뒤에 물음표를 붙이고 접근해주면 null이 아닐 경우에만 실행이된다.
    println(a?.length) // null


    //null에 대한 조건이 들어왔을 때 반환하는 방법
    val b : Int = if (a != null) a.length else 0
    println(b) // 0

    //위 코드를 if else 말고도 엘비스 연산자를 사용하여 처리가 가능하다.
    //좌변이 널인 경우 우변을 반환
    val c = a?.length ?: 0
    println(c) // 0


    val nullableStr = getNullStr()
    println(nullableStr?.length ?: "null인 경우 반환".length) // 11
    println(getLengthIfNotNull(null)) // 0


    //코틀린도 NPE가 발생할 수는 있다. 가능성이 크게 줄어들 뿐이지 발생은 할 수 있다.

    //NPE를 직접 호출하는 경우
/*
    throw java.lang.NullPointerException()
*/

    //단언 연산자를 사용하는경우. 단언 연산자는 개발자가 null아 아니라고 컴파일러에게 알려주고 싶을때
/*  val d: String? = null
    val e = d!!.length // NPE발생!
*/

    //자바와 상호운영하는 경우도 발생할 수 있다.
    //null을 반환하는 자바 메서드를 코틀린에서 호출하면
/*
    println(Java_NullSaftey.getNullStr().length) // NPE!!
*/

    //코틀린은 이것까지 잡아주지 못하기 때문에 자바와 상호 운영할때에는 항상 널러블을 감안하고 사용해야한다.
    println(Java_NullSaftey.getNullStr()?.length ?: 0) //0

}

fun getNullStr() : String? = null

fun getLengthIfNotNull(str : String?) = str?.length ?: 0

