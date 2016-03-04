package org.pengisgood

object Utils {
  def format(f: Float, precision: Int = 2): String = {
    s"%.${precision}f".format(f)
  }
}
