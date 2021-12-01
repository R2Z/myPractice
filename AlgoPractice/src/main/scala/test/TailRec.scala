package test

import scala.annotation.tailrec

object TailRec {

  def factorial2(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 0) result
      else iter(x - 1, result * x)

    iter(n, 1)
  }

  def factorial(n: Int): Int = {
    @tailrec
    def iter(x: Int, accumulator: Int): Int =
      x match {
        case 0 => accumulator
        case _ => iter(x - 1, accumulator * x)
      }
    iter(n, 1)
  }

  def main(args: Array[String]): Unit = {
    println(factorial(4))
    println(factorial2(4))
  }

}
