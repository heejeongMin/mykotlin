fun main(){

    //if..else 식
    val job = "Software Developer"

    if (job == "Software Developer") {
        println("개발자")
    } else {
        println("개발자 아님")
    }


    //코틀린의 if..else는 표현식이다
    //값 리턴이 가능하다.
    val age :Int = 10
    var str = if(age > 10) {
        "성인"
    } else {
        "아이"
    }

    //코틀린은 삼항 연산자가 없다. if..else가 표현식임으로 불필요하다
    val a = 1
    val b = 2
    val c = if (b>a) b else a
}