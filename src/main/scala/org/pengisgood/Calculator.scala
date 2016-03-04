package org.pengisgood

object Calculator {

  //TODO parse discount from file
  val discount = Map(0 -> new NoDiscount, 1 -> new BuyXGiveY(2, 1), 2 -> new Off(0.95f))

  def apply(item: Item, inventory: Map[String, Goods]): (Float, Float, String, String) = {
    val goods = inventory.get(item.barcode).get

    discount.get(goods.discountType).get.calc(item, goods)
  }

}
