package org.stairwaybook.recipe

import org.stairwaybook.recipe._

object SimpleDatabase extends Database
    with SimpleFoods with SimpleRecipes

object SimpleBrowser extends Browser {
    val database = SimpleDatabase
}

object StudentDatabase extends Database {
    object FrozenFood extends Food("FrozenFood")

    object HeatItUp extends Recipe(
        "heat it up",
        List(FrozenFood),
        "Microwave the 'food' for 10 minutes.")
        
    def allFoods = List(FrozenFood)
    def allRecipes = List(HeatItUp)
    def allCategories = List(
        FoodCategory("edible", List(FrozenFood)))
}

object StudentBrowser extends Browser {
    val database = StudentDatabase
}
