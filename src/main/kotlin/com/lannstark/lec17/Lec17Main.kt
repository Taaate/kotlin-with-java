package com.lannstark.lec17

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    val isApple  = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    val isApple2 = {fruit: Fruit -> fruit.name == "사과"}

    isApple(fruits[0])
    isApple.invoke(fruits[0])

    println(filterFruits(fruits, isApple))

    val isAllApple = fruits.all(isApple)
    val isNoApple = fruits.none(isApple2)
    val isAnyApple = fruits.any { fruit -> fruit.price >= 10_000 }
    val fruitCount = fruits.count()
    val fruitSort = fruits.sortedBy { fruit -> fruit.price }
    val fruitSort2 = fruits.sortedByDescending { fruit -> fruit.price }

}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    val result = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            result.add(fruit)
        }
    }
    return result
}

private fun filterFruits2(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(filter)
}
