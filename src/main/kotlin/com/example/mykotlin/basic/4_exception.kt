fun main(){

    //checkedException을 강제하지 않기 때문에 컴파일 에러가 나지 않는다.
    Thread.sleep(1)


    //개발자가 try/catch/finally가 필요하면 넣을 수 는 있다.
    try {
        Thread.sleep(1)
    } catch (e: Exception) {
        println("에러 발생!!")
    } finally {
        println("finally 실행!") // finally 실행!
    }

    //표현식이기 때문에 값 전달도 가능
    val a = try {
        "1234".toInt()
    } catch (e: Exception) {
        println("예외 발생!")
    }

    println(a) // 1234

    //직접 exception을 발생시키고 싶다면 throw사용
/*
    throw Exception("예외 발생!")
*/

    val b: String? = null
    val c = b ?: failFast("b is null")

    print(c.length) //Nothing 타입과 앨비스 연산자를 사용하면 값이 null일 수 없기 때문에 안전연산자를 사용하지 않아도됨

}

// 함수에서 throw를 리턴하게 되면 함수는 Nothing이라는 특별한 타입을 반환하게 된다.
// Nothing타입을 반환하게 되면 코틀린 컴파일러가 파악을 해서 그 이후 코드는 실행하지 않게된다.
fun failFast(message: String) : Nothing {
    throw java.lang.IllegalArgumentException(message)
}