package org.pengisgood

import scala.io.Source

object Pos {

  def main(args: Array[String]): Unit = {
    val pos = new Pos()
    val items = pos.parseCartData("cart.txt")
    val inventory = pos.parseInventoryData("inventory.txt")
    println(pos.checkout(items, inventory))
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

  def parseInventoryData(fileName: String): Map[String, Goods] = {
    Source.fromURL(getClass.getClassLoader.getResource(fileName)).getLines().toList
      .map(line => {
        val elems = line.split(',')
        (elems(0), Goods(elems(0), elems(1).toFloat, elems(2), elems(3), elems(4).toInt))
      }).toMap
  }

  def checkout(items: Seq[Item], inventory: Map[String, Goods]): String = {
    val order = items.map(item => {
      Calculator(item, inventory)
    })

    new Invoice(order).toString
  }
}
