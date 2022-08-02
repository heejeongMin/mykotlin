

fun main () {
    //let
    //null이 아닌 경우 사용될 로직을 작성하고 그에 따른 새로운 결과를 반환하고 싶을때 사용한다

    val str : String? = null
    str?.let {
        println(it) //아무것도 반환되지 않음! 왜냐하면 str이 null이라 안전연산자가 작동하여 let이 실행되지 않음
    }

    val str2 : String? = "안녕"
    str2?.let {
        println(it) //안녕
    }

    val result : Int? = str2.let {
        println(it) // 1234

        1234
    }

    println(result) // 1234


    //let은 중첩해서 사용하는 경우가 많다. 하지만 가독성이 좋지 않기 때문에 이런 경우 스코프 함수 보다는 if else 를 사용하는 것이 좋다.
    val result2 : Int? = str2.let {
        println(it) // 안녕

        val abc : String? = "abc"
        abc?.let {
            val def : String? = "def"
            def?.let {
                println("abcdef가 null이 아님") // abcdef가 null이 아님

            }
        }

        1234
    }

    println(result2) // 1234

    val result3 : Int? = str2.let {
        println(it) // 안녕

        val abc: String? = "abc"
        val def: String? = "def"
        if(!abc.isNullOrEmpty() && !def.isNullOrEmpty()) {
            println("abcdef가 null이 아님") // abcdef가 null이 아님

        }

        1234
    }
    println(result3) // 1234


}

