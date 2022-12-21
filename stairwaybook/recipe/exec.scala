import org.stairwaybook.recipe._
val apple = SimpleDatabase.foodNamed("Apple").get
SimpleBrowser.recipesUsing(apple)
