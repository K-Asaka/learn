package org.stairwaybook.recipe

trait SimpleRecipes {           // コンパイルできない
    object FruitSalad extends Recipe(
        "fruit salad",
        List(Apple, Pear),      // スコープが…
        "Mix it all together."
    )
    def allRecipes = List(FruitSalad)
}
