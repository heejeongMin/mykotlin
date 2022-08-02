
//enum키워드를 사용해서 열거형 클래스를 만든다
// enum클래스에 함수를 구현하는 경우 마지막 상수에 세미콜론을 붙여주어야 한다.
// 동등성 비교, valueOf, values 는 자바와 동일하다
enum class PaymentStatus(val label : String) : Payable {
    UNPAID("미지급") {
        override fun isPayable() = true
    },
    PAID("지급완료") {
        override fun isPayable() = false
    },
    FAILED("지급실패") {
        override fun isPayable() = false
    },
    REFUNDED("환불") {
        override fun isPayable() = false
    };
}

interface Payable {
    fun isPayable() : Boolean
}

fun main () {
    println(PaymentStatus.UNPAID.label) //미지급

    if(PaymentStatus.UNPAID.isPayable()) {
        println("결제 가능 상태") // 결제 가능 상태
    }

    for (status in PaymentStatus.values()) {
        println("[${status.name}](${status.label}) : ${status.ordinal}")
    }
}