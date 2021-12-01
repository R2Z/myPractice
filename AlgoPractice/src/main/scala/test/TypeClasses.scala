package test

object TypeClasses {

  case class StudentId(id: Int)
  case class StaffId(id: Int)
  case class Score(s: Double)

  trait Printer[A] {
    def getString(a: A): String
  }

  def show[A](a: A)(implicit printer: Printer[A]): String = printer.getString(a)

  implicit val studentPrinter: Printer[StudentId] = new Printer[StudentId] {
    def getString(a: StudentId): String = s"StudentId: ${a.id}"
  }

  implicit val staffPrinter: Printer[StaffId] = new Printer[StaffId] {
    def getString(a: StaffId): String = s"StaffId: ${a.id}"
  }

  implicit val scorePrinter: Printer[Score] = new Printer[Score] {
    def getString(a: Score): String = s"Score: ${a.s}"
  }

  def main(args: Array[String]): Unit = {

    val studentId = StudentId(25)
    val staff = StaffId(10)
    val score = Score(20.5)
    println(show(studentId))
    println(show(staff))
    println(show(score))
  }

}
