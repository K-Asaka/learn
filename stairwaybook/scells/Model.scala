package org.stairwaybook.scells
import swing._

class Model(val height: Int, val width: Int) 
        extends Evaluator with Arithmetic {
    case class ValueChanged(cell: Cell) extends event.Event
    case class Cell(row: Int, column: Int) extends Publisher {
        var formula: Formula = Empty
        def value = evaluate(formula)

        override def toString = formula match {
            case Textual(s) => s
            case _ => value.toString
        }
    }

    val cells = Array.ofDim[Cell](height, width)
    for (i <- 0 until height; j <- 0 until width)
        cells(i)(j) = new Cell(i, j)
    
}