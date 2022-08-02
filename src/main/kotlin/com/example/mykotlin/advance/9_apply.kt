
//apply는 수신객체 프로퍼티를 구성하고 수샌긱체의 결과를 그대로 반환하고 싶을때 사용한다.

fun main () {

    //run 과 apply의 차이는 apply는 수산재 각채 그대로 반환한다는 것이다.
    val client : DatabaseClient = DatabaseClient().apply {
        url = "localhost:3306" //수신자 객체 참조 this 생략
        username = "mysql"
        password = "1234"
/*
        connect() // 실행이 되어도 함수의 결과를 반환하지 않기 때문에 수신객체가 반환됨
*/
    }

    println(client) // DatabaseClient@27bc2616

   val connected =  client.connect()
    println(connected) // true

    // apply 이후 run을 응용하면, 아래와 같다.
    client.connect().run { println(this) } // true
}