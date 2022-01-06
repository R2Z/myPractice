package test

object TestObj {

  def main(args: Array[String]): Unit = {
    val nums = List[Int](1, 2, 3)
    val pairs = nums.combinations(2).toList
    println(pairs)
  }

  def composePairs(nums: Seq[Int]) =
    nums.flatMap(x => nums.map(y => (x,y)))

}
