package com.example.mykotlin

import java.util.LinkedList

fun main() {

    //immutable list
    val currency = listOf("달러", "유로", "원") //list 표준 라이브러리. listOf는 팩토리 메서드

    //mutable list
    val mutableCurrency = mutableListOf<String>() //생성하면서도 넣을 수 있찌만 예시에서는 mutable을 보여주기위해 add 사용
    mutableCurrency.add("달러")
    mutableCurrency.add("유로")
    mutableCurrency.add("원")

    //apply라는 인라인 함수를 사용하여 가독성을 올릴 수 있다.
    val mutableCurrency2 = mutableListOf<String>().apply {
        this.add("달러")    //mutable 컬렉션 자체가 this라는 참조를 가진다.
        add("유로")
        add("원")
    }

    //immutable set
    val number = setOf(1, 2, 3, 4)

    //mutable set
    val mutableNubmer = mutableSetOf<Int>().apply {
        add(1)
        add(2)
        add(3)
        add(4)
    }

    //immutable map
    //key to value
    val numberMap = mapOf("one" to 1, "two" to 2)

    //mutable map
    val mutableNumberMap = mutableMapOf<String, Int>()
    mutableNumberMap["one"] = 1
    mutableNumberMap.put("two", 2) //이렇게도 가능하지만, 함수보다는 literal 문법 사용을 추천하기 때문에 warning이 뜸
    mutableNumberMap["three"] = 3



    //collectionBuilder
    // collection builder를 사용하면 apply를 사용하는것보다 코드가 간결해진다
    //buildList내부에서 add를 사용하고 있는데, add는 위에서 보면 mutable list, set에 사용이 되었는데,
    //buildList내부에서는 mutablelist를 사용해서 값을 넣고 반환할때는 immutable한 list를 반환한다.
    val numberList = buildList{
        add(1)
        add(2)
        add(3)
    }

    //구현체의 생성자를 사용해서 생성할 수도 있다.
    //linkedList
    val linkedList = LinkedList<Int>().apply {
        addFirst(3)
        add(2)
        addLast(1)
    }

    //arraylist
    var arrayList = ArrayList<Int>().apply {
        add(1)
        add(2)
        add(3)
    }

    //반복

    //iterator
    val iterator = currency.iterator()
    while(iterator.hasNext()){
        println(iterator.next())
    }

    println()

    //for
    for(cur in currency) {
        println(cur)
    }

    println()

    //foreach
    currency.forEach {
        println(it) //it 은 뒤에 람다 설명시 나온다
    }

    println()

    //for loop ->  map / for loop -> filter

    val lowerList = listOf("a", "b", "c")

    // for loop
/*
        val upperList = mutableListOf<String>()
        for(lowerCase in lowerList){
        upperList.add(lowerCase.uppercase())

        println(upperList) // [A, B, C]
    }*/

    //map
    val upperlist = lowerList.map {it.uppercase()}
    println(upperlist) // [A, B, C]

/*    val filteredList = mutableListOf<String>()
    for (upperCase in upperlist){
        if(upperCase == "A" || upperCase == "C") {
            filteredList.add(upperCase)
        }
    }
    println(filteredList) // [A, C]*/

    val filteredList = upperlist.filter { it == "A" || it == "C" }
    println(filteredList) //[A, C]

    //자바에서는 terminal operator라고 해서 map, filter와 같은 중간연산자를 사용하면, 종료 연산자가 호출이 되어야 하지만 코틀린은 아니다
    //코틀린에서 streeam과 유사하게 작동하는게 asSequence() 인데 이걸 사용하게 되면 terminal operator 사용해야 한다.
    //연산자가 많아지만 개발 연산자가 실행될때마다 조건에 맞는 컬랙션이 매번 생성이 된다. 만일 대량의 데이터를 사용하는 경우 메모리 낭비를 하지 않기 위해서 인라인 함수의 체인이 많아지만 asSequence를 사용하여
    //terminal operator로 종료시켜 주면 중간 연산자에서 리스트를 각각 만들지 않고 terminal operator가 실행될때 한번 만들기 때문에 메모리를 낭비하지 않을 수 있다.
    //데이터가 많지 않는 경우, 오만건 십만건 정도 이면 그냥 인라인이 더 낫다고 함.
    val anotherFilteredList =
        upperlist
            .asSequence()
            .filter { it == "A" || it == "C" }
            .toList()



}