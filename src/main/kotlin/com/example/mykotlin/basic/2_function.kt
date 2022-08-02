
//기본적인 함수 선언 스타일
//fun키워드 함수명(인자: 인자의타입) : 함수가 반환할 타입 { 바디 }
fun sum(a: Int, b: Int) : Int {
    return a + b
}

//표현식 스타일 함수
//바디 없이 로직만 들어있음
fun sum2(a: Int, b: Int) : Int = a + b

// 표현식 & 반환타입 생략
// 변수도 타입을 지정하지 않아도 추론해주는것처럼 함수도 반환 타입을 생략하면 코틀린이 추론해 준다.
fun sum3(a : Int, b: Int) = a + b

//단 바디가 있는 함수의 경우 반환 타입을 제거 하면 컴파일 오류가 난다.
/*
    fun sum4(a: Int, b: Int) { //컴파일 에러
        return a + b
    }
 */

//반환타입이 없는 함수는 Unit을 반환한다. 자바로 치면 void
//아래는 : Unit 이라는 반환 타입을 생략한 형태
fun printSum(a: Int, b: Int) {
    println("$a + $b = ${a + b}")
}



//디폴트 파라미터
fun greeting(message: String = "안녕하세요!!") {
    println(message)
}

fun main(){
    greeting() // 안녕하세요!!
    greeting("HI!!!") // HI!!

    log(message = "인포로그") //[INFO]인포로그
    log(level = "DEBUG", "디버그 로그") //[DEBUG]디버그 로그
    log("WARN", "워닝 로그") //[WARN]워닝 로그
    log(level = "ERROR", message = "에러 로그") //[ERROR]에러 로그
}

//named argument = 이름과 값을 매핑하는 것
fun log(level: String = "INFO", message: String) {
    println("[$level]$message")
}


