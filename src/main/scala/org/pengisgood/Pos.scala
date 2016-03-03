package org.pengisgood

import scala.io.Source

object Pos {

  def main(args: Array[String]): Unit = {
    val items = new Pos().parseCartData("cart.txt")

  }
}

class Pos {
  //TODO validation needed for the input data
  def parseCartData(fileName: String): Seq[Item] = {
    Source.fromURL(getClass.getClassLoader.getResource(fileName)).getLines().toList
      .drop(1).dropRight(1)
      .map(_.split('\'')(1))
      .groupBy(_.split('-')(0))
      .map(entry => {
        val quantity = entry._2.foldLeft(0)((acc, item) => {
          item match {
            case i if item.contains('-') => acc + item.split('-')(1).toInt
            case _ => acc + 1
          }
        })
        Item(entry._1, quantity)
      }).toSeq
  }
}
