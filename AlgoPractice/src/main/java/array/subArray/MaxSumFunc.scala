package array.subArray

object MaxSumFunc {

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 4, 2, 10, 2, 3, 1, 0, 20)
    val window = 4
    val result = arr.sliding(window).toList.foldLeft(0)((maxSum, subArray) => Math.max(maxSum, subArray.sum))
    print(result)
  }
}
