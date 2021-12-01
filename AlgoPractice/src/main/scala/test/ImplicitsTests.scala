package test

object ImplicitsTests {

  //https://stackoverflow.com/questions/10375633/understanding-implicit-in-scala
  def main(args: Array[String]): Unit = {
    def testImplicits: Unit = {
      import Extensions._

      implicit def doubleToInt(d: Double) = d.toInt

      val x: Int = 42.5
      println(s"x ${x.meterToCm}")
      val y: Int = 42.5
      println(s"x ${x.meterToCm} y $y")
    }

    testImplicits

    //val x: Int = 42.5
    //println(s"x $x")
    println()
  }
}

object Extensions {
  implicit class MeterToCm(meter: Int) {
    def meterToCm: Int = {
      meter * 100
    }
  }

}
