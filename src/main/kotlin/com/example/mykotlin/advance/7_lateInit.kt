//가변 프로퍼티에대한 지연 초기화가 필요한 경우 lateInit을 사용한다.
//프레임워크나 라이브러리에서 불변객체에 대한 초기화를 제공하지 않아서 가변 프로퍼티를 꼭 써야하고 지연 초기화가 필요할때 사용할 수 있다.

class Test {
    // 초기화를 해주지 않아도 lateinit을 사용하면 컴파일 에러가 나지 않는다. var대산 val을 사용하면 컴파일 오류가 남
    // lateinit을 사용하면 nonnull이다.
    lateinit var text: String

    fun printText() { //초기화를 먼저 해주지 않고 사용하게 되면 런타임 에러가 나니 주의
        if(this::text.isInitialized) { //isInitialized는 클래스 내부에서는 사용가능한데 외부에서는 사용할 수 없다.
            println("초기화됨")
        } else {
            text = "안녕하세요"
        }

        println(text)
    }

    //initalized를 외부에서 사용하고 싶다면 getter로 한번 감싸주어야한다.
    val textInitialized: Boolean
        get() = this::text.isInitialized
}

fun main() {
    val test = Test()
    println(test.textInitialized) //false
    test.printText() // 안녕하세요

    println(test.textInitialized) //true
    test.printText() // 초기화됨 안녕하세요

}
