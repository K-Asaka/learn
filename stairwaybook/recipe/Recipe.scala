package org.stairwaybook.recipe

class Recipe(
    val name: String,               // 名前
    val ingredients: List[Food],    // 材料リスト
    val instructions: String        // 手順
) {
    override def toString = name
}
