package org.pengisgood

class PosSpec extends org.specs2.mutable.Specification {
  "app" should {
    val pos = new Pos()

    "parse valid cart input file" in {
      val items = pos.parseCartData("cart.txt")

      items.size mustEqual 3
      items.contains(Item("ITEM000001", 5)) must beTrue
    }

    "parse valid inventory input file" in {
      val inventory = pos.parseInventoryData("inventory.txt")

      inventory.keys.size mustEqual 3
      inventory.get("ITEM000001").get mustEqual Goods("ITEM000001", 1.00f, "羽毛球", "个", 1)
    }
  }

}
