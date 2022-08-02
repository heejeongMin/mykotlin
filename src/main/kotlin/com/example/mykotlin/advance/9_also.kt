//부수작업을 실행하거나, 전달받은 객체를 그대로 전달하고 싶을때 사용하는것이 also


class User(val name : String, val password: String ) {

     fun validate() {
         if(name.isNotEmpty() && password.isNotEmpty()) {
             println("검증 성공!")
         } else {
             println("검증 실패!")
         }
     }

    fun printName() = println(name)

 }

 fun main() {

     val user : User = User(name = "tony", password = "1234")
     user.validate()

     // 위 코드를 이렇게 바꿀 수 있다.
     User(name = "tony", password = "1234").also {
         it.validate()
         it.printName()
     }
 }