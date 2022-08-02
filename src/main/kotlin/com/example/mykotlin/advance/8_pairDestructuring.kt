

fun plus (a: Int, b: Int) = a + b

//Tuple
data class Tuple (val a : Int, val b : Int)
fun plus2(tuple : Tuple) = tuple.a + tuple.b

//코틀린에서는 위에 Tuple 형태를 Pair라는 클래스로 이미 제공하고 있다.
fun plus3(pair : Pair<Int, Int>) = pair.first + pair.second



fun main() {
    println(plus(1,3)) // 4
    println(plus2(Tuple(1,3))) // 4
    println(plus3(Pair(1,3))) // 4

    //Pair는 data 클래스로 되어 있다.
    val pair = Pair("A", 1)
/*
    pair.first = "B" //컴파일 에러가 난다. first, second는 불변으로 되어있다.
*/
    //값을 바꿀수는 없지만 copy를 통해서 새로운 클래스를 만들 수 는 있다.
    val newPair = pair.copy(first = "B")
    println(newPair) // (B, 1)

    val second = newPair.component2()
    println(second) // 1

    val list = newPair.toList() // Pair의 확장함수인 toList를 사용하면 이뮤터블한 리스트형태를 만들어준다.
    println(list) // [B, 1]

    //Triple도 존재한다.
    val triple = Triple("A", "B", "C")
    println(triple) // (A, B, C)
    triple.first
    triple.second
    triple.third
    val newTriple = triple.copy(third = "D")
    println(newTriple) // (A, B, D)

    println(newTriple.component3()) //D



    //구조분해할당
    val (a, b, c) = newTriple
    println("$a, $b, $c") // A, B, D

    //타입을 명시할 수 도 있다. 내부적으로는 componentN을 사용한다.
    val (d : String, e : String, f : String) = newTriple

    val list3 = newTriple.toList()
    val (a1, a2, a3) = list3 // 트리플이아니라 리스트여도 사용할 수 있다. 리스트도 내부적으로 componentN함수를 가지고 있따는 말 .
    println("$a1, $a2, $a3") // A, B, D

    //5개가 존재하는데 리스트가 값이 더 많이 존재할 수 있으니 5개씩 주긴하나, 지금 값이 3개밖에 없음으로 component4에 접근하면 ArrayIndexOutOfBoundsException 에러남
    println(list3.component1()) // A
    println(list3.component2()) // B
    println(list3.component3()) // D
/*
    println(list3.component4()) // ArrayIndexOutOfBoundsException
    println(list3.component5()) // ArrayIndexOutOfBoundsException
*/


    //map의 구조분해 할당
    //to 라는 중위표현식은 내부적으로 Pair로 되어있다. 따라서 mutableMapOf(Pair("이상훈", "개발자"))로 치환 가능
   val map = mutableMapOf("이상훈" to "개발자")
    for ( (key, value) in map) {
        println("${key}의 직업은 $value") // 이상훈의 직업은 개발자

    }




}