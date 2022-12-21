package org.stairwaybook.recipe

object SimpleDatabase extends Database {
    def allFoods = List(Apple, Orange, Cream, Sugar)
    def allRecipes: List[Recipe] = List(FruitSalad)

    private var categories = List(
        FoodCategory("fruits", List(Apple, Orange)),
        FoodCategory("misc", List(Cream, Sugar)))
    
    def allCategories = categories
}

object SimpleBrowser {
    def recipesUsing(food: Food) =
        SimpleDatabase.allRecipes.filter(recipe =>
            recipe.ingredients.contains(food))
    
    def displayCategory(category: SimpleDatabase.FoodCategory) = {
        println(category)
    }
}
