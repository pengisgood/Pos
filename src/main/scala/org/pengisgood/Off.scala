package org.pengisgood

import Utils.format

class Off(discount: Float) extends Discount {
  def calc(item: Item, goods: Goods) = {
    val total = goods.price * item.quantity
    val amount = total * discount
    val des = s"名称：${goods.name}，数量：${item.quantity}${goods.unit}，单价：${format(goods.price)}(元)，小计：${format(amount)}(元)，节省：${format(total - amount)}(元)"

    (total, amount, des, "")
  }
}
