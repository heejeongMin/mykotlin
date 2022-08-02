fun main() {

    // 자바 코드를 코틀린의 when식으로 변환한 코드 (자바의 switch문과 유사하다)
    val day = 2
    val result = when (day) {
        1 -> "월요일"
        2 -> "화요일"
        3 -> "수요일"
        4 -> "목요일"
        else -> "기타"
    }

    println(result) // "화요일"

    // else를 생략할 수 있다
    //Color에서 나올 수 있는 부분이 red, green 두개밖에 없음을 코틀린이 알고 else 를 생략할 수 있게 해준다.
    when(getColor()){
        Color.RED -> println("red")
        Color.GREEN -> println("green")
    }

    // 여러개의 조건을 콤마로 구분해 한줄에서 정의할 수 있다
    when(getNumber()) {
        0, 1 -> print("0 또는 1")
        else -> print("0 또는 1이 아님")
    }
}

enum class Color {
    RED, GREEN
}

fun getColor() = Color.RED

fun getNumber() = 2