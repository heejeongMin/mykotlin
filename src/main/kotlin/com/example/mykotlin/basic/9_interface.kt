
class Product(val name: String, val price: Int)


interface Wheel {
    fun roll()
}


//인터페이스를 만들때에는 interface라틑 키워드를 사용하면 된다
//프로퍼티도 존재한다. 구현 클래스에서 구현해야하는 추상 프로퍼티가 된다.
//인터페이스 끼리도 구현 가능
interface Cart : Wheel {

    //추상 프로퍼티
    var coin : Int

    //getter접근자를 통한 프로퍼티 구현 가능하다.
    //이 경우, 내부에 프로퍼티 초기값이 없기 때문에 인터페이스 자체에서 백킹 필드에 접근 할 수 없다. field 키워드 사용 못함
    //따라서 특정 값을 만들어주는 경우만 getter를 사용할 수 있다.
    val weight : String
        get() = "20KG"

    fun add(product: Product)

    // default 함수
    fun rent() {
        if (coin>0) {
            println("카트를 대여합니다")
        }
    }

    override fun roll() {
        println("카트가 굴러갑니다")
    }

    fun printId() = println("1234")
}


interface Order {
    fun add(product: Product) {
        println("${product.name} 주문이 완료되었습니다")
    }

    fun printId() = println("5678")
}

//인터페이스를 구현할대 콜론 뒤에 적어주는대 상속과 다른 점은 생성자 호출을 하지 않는다. Cart()  아님
//복수개의 인터페이스 구현 가능하며 콤마로 구분한다
//복수개의 인터페이스 구현시 동일한 시그니처의 함수를 구현할때 문제가 생길 수 있다.
class MyCart(override var coin: Int) : Cart, Order {

    override fun add(product: Product) {
        if(coin <= 0) println("코인을 넣어주세요")
        else println("${product.name}이(가) 카트에 추가됐습니다")

        //상위 인터페이스의 동일한 시그니쳐의 함수를 호출하고 싶으면 super키워드를 사용하고 꺽새 안에 해당 인터페이스 명을 적어준다
        //이 구현을 하지 않으면 Order의 add는 호출되지 않는다.
        super<Order>.add(product)
    }

    //rent는 default함수 이기 때문에 MyCart애서는 override가 필수 아님


    //두개의 인터페이스에 동일한 시그니쳐의 default함수가 두 인터페이스에 모두 존재한다면 하위 클래스에서 구현을 강제한다.
    override fun printId() {
        super<Cart>.printId()
        super<Order>.printId()
    }

}


fun main (){
    val cart = MyCart(coin = 100)
    cart.rent() // 카트를 대여합니다
    cart.roll() //카트가 굴러갑니다
    cart.add(Product(name = "장난감", price = 1000)) //장난감이(가) 카트에 추가됐습니다, 장난감 주문이 완료되었습니다
    cart.printId() // 1234, 5678

}