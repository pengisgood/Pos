package org.pengisgood

import Utils.format

class Invoice(order: Seq[(Float, Float, String, String)]) {
  val HEADER = "***<没钱赚商店>购物清单***"
  val SEPARATOR = "----------------------"
  val BOTTOM = "**********************"

  override def toString: String = {
    val specialGoods = order.map(_._4).filterNot(_.isEmpty).mkString("\n")
    println(specialGoods)
    val total = order.map(_._1).sum
    val amount = order.map(_._2).sum

    s"""
       |$HEADER
       |${order.map(_._3).mkString("\n")}
       |${if (!specialGoods.isEmpty) List(SEPARATOR, specialGoods, SEPARATOR).mkString("\n") else SEPARATOR}
       |总计：${format(amount)}(元)
       |${if (format(total - amount).equals("0.00")) BOTTOM else s"节省：${format(total - amount)}(元)\n$BOTTOM"}
     """.stripMargin
  }
}
