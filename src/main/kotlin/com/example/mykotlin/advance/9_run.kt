class DatabaseClient {
    var url : String? = null
    var username : String ? = null
    var password : String ? = null

    //DB에 접속하고 Boolean 결과를 반환
    fun connect(): Boolean {
        println("DB 접속 중 ...")
        Thread.sleep(1000)
        println("DB 접속 완료")
        return true
    }
}

fun main () {

    //run 스코프 함수를 사용하지 않는 경우
    val config = DatabaseClient()
    config.url = "localhost:3306"
    config.username = "mysql"
    config.password = "1234"
    val connected1 = config.connect()

    println(connected1) // true


    //run 스코프 함수를 사용하는 경우
    val connected2 = DatabaseClient().run {
        url = "localhost:3306" //수신자 객체 참조 this 생략
        username = "mysql"
        password = "1234"
        connect() //let과 마찬가지로 마지막 실행 결과를 반환한다.
    }

     println(connected2) // true
}