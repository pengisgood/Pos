package org.pengisgood

trait Discount {
  def calc(item:Item, goods: Goods): (Float, Float, String, String)
}
