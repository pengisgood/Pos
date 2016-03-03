package org.pengisgood

class PosSpec extends org.specs2.mutable.Specification {
  "app" should {
    "parse valid cart input file" in {
      val items = new Pos().parseCartData("cart.txt")

      items.size mustEqual 3
      items.contains(Item("ITEM000001", 5)) must beTrue
    }
  }

}
