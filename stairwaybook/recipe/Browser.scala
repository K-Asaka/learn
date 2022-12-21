package org.stairwaybook.recipe

abstract class Browswer {
    val database: Database

    def recipesUsing(food: Food) =
        database.allRecipes.filter(recipe =>
            recipe.ingredients.contains(food))
    
    def displayCategory(category: database.FoodCategory) = {
        println(category)
    }
}
