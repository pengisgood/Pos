package org.pengisgood

import Utils.format

class BuyXGiveY(x: Int, y: Int) extends Discount {
  def calc(item: Item, goods: Goods) = {
    val free = item.quantity / (x + y)
    val amount = goods.price * (item.quantity - free)
    val des = s"名称：${goods.name}，数量：${item.quantity}${goods.unit}，单价：${format(goods.price)}(元)，小计：${format(amount)}(元)"
    val specialDes = s"名称：${goods.name}，数量：$free"

    (item.quantity * goods.price, amount, des, specialDes)
  }
}
