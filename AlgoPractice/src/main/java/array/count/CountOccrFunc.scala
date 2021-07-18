package array.count

object CountOccrFunc {

  def main(args: Array[String]): Unit = {
    val arr = Array(0, 5, 5, 5, 4)
    val x = 5
    val occur = arr.count(_ == x)
    print(occur)
  }

}
