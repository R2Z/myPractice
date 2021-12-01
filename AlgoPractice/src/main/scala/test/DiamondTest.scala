package test

object DiamondTest {

  trait one {
    def show = println("one")
  }

  trait two extends one {
    override def show = println("two")
  }

  trait three extends one {
    override def show = println("three")
  }

  class four extends two with three

  class five extends three with two

  def main(args: Array[String]): Unit = {

    val f1 = new four
    val f2 = new five
    f1.show
    f2.show

  }
}
