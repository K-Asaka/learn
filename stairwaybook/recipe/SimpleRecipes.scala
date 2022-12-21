package org.stairwaybook.recipe

trait SimpleRecipes {
    this: SimpleFoods => 

    object FruitSalad extends Recipe(
        "fruit salad",
        List(Apple, Pear),      // これでPearはスコープに入る
        "Mix it all together."
    )
    def allRecipes = List(FruitSalad)
}
