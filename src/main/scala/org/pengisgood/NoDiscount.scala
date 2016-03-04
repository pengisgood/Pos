package org.pengisgood
import Utils.format

class NoDiscount extends Discount {
  def calc(item: Item, goods: Goods) = {
    val amount = goods.price * item.quantity
    val des = s"名称：${goods.name}，数量：${item.quantity}${goods.unit}，单价：${format(goods.price)}(元)，小计：${format(amount)}(元)"

    (amount, amount, des, "")
  }
}
