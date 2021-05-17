package array.subArray

object SearchElementInSegFunc {
  def main(args: Array[String]): Unit = {
    //val arr = Array(3, 5, 2, 4, 9, 3, 1, 7, 3, 11, 12, 3)
    //val arr = Array(21, 23, 56, 65, 34, 54, 76, 32, 23, 45, 21, 23, 25)
    val arr = Array(5, 8, 7, 12, 14, 3, 9)
    val segment = 8
    val search = 2
    val subPartition: List[Array[Int]] = arr.sliding(segment, segment).toList
    val result = subPartition.foldLeft(true)(_ && _.contains(search))
    print(result)

  }
}
