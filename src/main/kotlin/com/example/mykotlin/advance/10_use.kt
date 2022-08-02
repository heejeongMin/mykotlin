import java.io.FileWriter

// 자바는 try with resource를 사용하면 finally 구문을 작성하지 않아도 close 처리가 가능하다.
// closeable, autocloseable 알 상속/구현한 객체들만 자바의 try with resource를 사용할 수 있다.
// 코틀린은 try with resource를 대체하는 use라는 확장함수가 존재한다.

fun main () {

    FileWriter("test.txt")
        .use {
            it.write("hello 안녕하세요")
        }
}