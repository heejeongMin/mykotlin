//우아하게 예외처리할 수 있는 runCatching이 있다.
//함수형 스타일의 result pattern을 구현한 함수가 성공하면 캡슐화된 결과를 반환하거나 예외가 발생하면 지정한 작업ㅇ르 수행하는 것을 result pattern이라고 한다.

fun getStr(): Nothing = throw Exception("예외 발생 시 기본 값으로 초기화")

fun main() {

    //runCatching없이
    val result = try {
        getStr()
    } catch (e: Exception) {
        println(e.message) // 예외 발생 시 기본 값으로 초기화
        "기본값"
    }
    println(result) // 기본값


    //runCatching

    val result2 = runCatching { getStr() }
        .getOrElse {
            println(it.message) //예외 발생 시 기본 값으로 초기화
            "기본값"
        }
    println(result2) // 기본값

    val result3 = runCatching { getStr() }
        .getOrNull()

    println(result3) //  null

    val result4 = runCatching { "성공" }
        .getOrNull()

    println(result4) // 성공

    val result5 = runCatching { getStr() }
        .exceptionOrNull()

    /* result5?.let {
        println(it.message) // 예외 발생 시 기본 값으로 초기화
        throw it //Exception in thread "main" java.lang.Exception: 예외 발생 시 기본 값으로 초기화
    }*/

    val result6 = runCatching { getStr() }
        .getOrDefault("기본값")
    println(result6) // 기본값

  /*  val result7: Nothing = runCatching { getStr() } //Nothing타입이 반환될때 사용가능
        .getOrThrow() // Exception in thread "main" java.lang.Exception: 예외 발생 시 기본 값으로 초기화
*/

    val result8: String = runCatching { "안녕" }
        .map {
            "${it}하세요" //성공한 값을 참조하는 수샌자 객체
        }.getOrThrow() // map의 반환타입이 Result<T> 이기 때문에 getOrThrow 같은 것을 사용해서 꺼내주어야한다.

    println(result8) //안녕하세요

 /*   val result9: String = runCatching { "안녕" }
        .map {
            throw Exception("예약")
        }.getOrDefault("기본값")

    //map안에서 처리 중 exception이 발생하면 getOrdefault 가 작동하지 않기 때문에 이런경우 mapCatching을 사용한다.
    println(result9) // Exception in thread "main" java.lang.Exception: 예약
*/
    val result10: String = runCatching { "안녕" }
        .mapCatching {
            throw Exception("예약")
        }.getOrDefault("기본값")

    println(result10) // 기본값

    val result11 = runCatching { "정상" }
        .recover { "복구" }
        .getOrNull()

    println(result11)  // 정상

    val result12 = runCatching { getStr() }
        .recover { "복구" }
        .getOrNull()

    println(result12)  // 복구 --> recover를 사용하는 경우 뭔가 좀더 복잡한 복구가 필요한 경우 사용하면 좋다~
    // recover 도 map과 마찬가지로 recover안에서 예외가 발생하면 그 이후가 실행되지 않기 때문에 이러내경우 recoverCatching을 사용해준다.

    val result13 = runCatching { getStr() }
        .recoverCatching {
            throw Exception("예외")
        }.getOrNull()

    print(result13) // null

}