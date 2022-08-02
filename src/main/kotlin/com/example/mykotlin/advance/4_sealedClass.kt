import com.example.mykotlin.BackendDeveloper

//실드클래스란
//상위 클래스 또는 인터페이스에서 하위클래스에 대한 정의를 제한하는 것
//실드 클래스는 같은 패키지, 같은 모듈안에서만 가능하다 (1.6 부터 이다. 그 전버전은 무조건 같은 파일안에 있어야한다)

// 실드클래스를 사용하지 않을 시
abstract class Developer {
    abstract val name : String
    abstract fun code(language : String)
}

object DeveloperPool {
    val pool = mutableMapOf<String, Developer>()

    fun add(developer: Developer) = when(developer){
        is BackedDeveloper -> pool[developer.name] = developer
        is FrontendDeveloper -> pool[developer.name] = developer
        else -> { //실드 클래스가 아닌 경우 else문이 빠지만 컴파일 오류가 난다.
            println("지원하지 않는 개발자 입니다")
        }
    }

    fun get(name: String) = pool[name]
}

data class BackedDeveloper(override val name : String) : Developer() {
    override fun code(language: String) {
        println("저는 백엔드 개발자 입니다. ${language}를  사용합니다")
    }
}

data class FrontendDeveloper(override val name: String) : Developer() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자 입니다. ${language}를  사용합니다")
    }
}


//실드 클래스인 경우
sealed class Developer2 {
    abstract val name : String
    abstract fun code(language : String)
}

object DeveloperPool2 {
    val pool = mutableMapOf<String, Developer2>()

    fun add(developer: Developer2) = when(developer){
        is BackedDeveloper2 -> pool[developer.name] = developer
        is FrontendDeveloper2 -> pool[developer.name] = developer
        // else 가 없어도 된다. 실드 클래스를 사용하면 하위 클래스를 제한 조건에 따라 정의해야하고, 컴파일 시점에 제한사항을 컴파일러가 확인해준다.
        // 실드 클래스 밑에 하위클래스가 뭐뭐 있는ㄴ지 컴파일러가 알고 else문을 필요없게 해준다
        /*else -> {
            println("지원하지 않는 개발자 입니다")
        }*/
    }

    fun get(name: String) = pool[name]
}

data class BackedDeveloper2(override val name : String) : Developer2() {
    override fun code(language: String) {
        println("저는 백엔드 개발자 입니다. ${language}를  사용합니다")
    }
}

data class FrontendDeveloper2(override val name: String) : Developer2() {
    override fun code(language: String) {
        println("저는 프론트엔드 개발자 입니다. ${language}를  사용합니다")
    }
}

/*
//하위 클래스가 하나 더 생기면 when식에서 컴파일러가 알아치리고 추가하라고 한다.
//object OtherDeveloper : Developer2 {
//    override val name: String = "익명"
//    override fun code(language: String) {
//
//    }
*/


fun main(){

    val backedDeveloper = BackedDeveloper(name = "토니")
    DeveloperPool.add(backedDeveloper)

    val frontendDeveloper = FrontendDeveloper(name = "카즈야")
    DeveloperPool.add(frontendDeveloper)

    println(DeveloperPool.get("토니")) // BackedDeveloper(name=토니)\
    println(DeveloperPool.get("카즈야")) // FrontendDeveloper(name=카즈야)


}