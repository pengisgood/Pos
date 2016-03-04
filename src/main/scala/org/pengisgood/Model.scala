package org.pengisgood

case class Item(barcode: String, quantity: Int)

case class Goods(barcode: String, price: Float, name: String, unit: String, discountType: Int)
