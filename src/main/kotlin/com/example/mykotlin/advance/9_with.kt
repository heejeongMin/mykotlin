
// with은 결과 반환없이 수신객체를 사용해서 다른 함수롤 호출하고 싶을때 사용할 수 있다.
// let과 run처럼 함수의 결과를 반환하는 것도 가능
fun main() {

    val str = "안녕하세요"

    with(str) {
        println("legnth = $length") // legnth = 5
    }

    val length = with(str) {
         length
    }
    println(length) // 5
}