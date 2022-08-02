class HelloBot {

    var greeting: String? = null
    fun sayHello() = println(greeting)
}

fun getHello() = "안녕하세요"

fun main() {
    val helloBot = HelloBot()

    helloBot.greeting = getHello() // 지연할당
    helloBot.sayHello() // 안녕하세요

    // 초기화는 한번만 되어서 초기화 로직 실행이 한번만 호출된 것을 볼 수 있따.
    val helloBot2 = HelloBot2()
/*    helloBot2.sayHello() // 초기화 로직 실행 안녕하세요
    helloBot2.sayHello() // 안녕하세요
    helloBot2.sayHello() // 안녕하세요*/

    for (i in 1 .. 5) {
        Thread {
            helloBot2.sayHello() // 병렬로 수행해도 처음 에만 초기화 로직 실행이 찍힌다
   다    }.start()
    }

}

// 위코드의 문제점은 var greeting이 가변변수로 선언하게되면 위험성이 있기때문에 될수 있으면 불변으로 유지하는 것이 좋다.
// 지연할당을 사용하게 되면 가변을 허용해야하기 때문에 이런경우 바이레이지를 사용할 수 있다.

class HelloBot2 {
    // by lazy를 사용하면 불변을 사용하면서 초기화를 지연할 수 있다. var 사용할 수 없음
    // 사용시점에 1회만 작동한다.
    //만일 by lazy(LazyThreadSafteyMode.NONE) 으로 설정하게되면 초기화 로직 수행 출력이 여러번 출력이 되는것을 볼 수 있는데 실행 할 때마다 호출 횟수가 일관성 잇지 않다
    //by lazy의 기본 mode 값은 LazyThreadSafteyMode.SYNCHRONIZED 이다.
    //멀티스레드에서도 동기화가 필요하지 않다면 PUBLICATION 모드를 사용할 수 있다. (동기화를 위한 오버헤드를 줄이고 싶다면)
    val greeting: String by lazy {
        println("초기화 로직 실행")
        getHello()
    }
    fun sayHello() = println(greeting)

}