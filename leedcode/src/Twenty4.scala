object Twenty4 {
  def allPossibleOpResultsV3(aPair:(Int, String), b:Int):List[(Int, String)] = {
    val (a,aStrTmp) = aPair
    val aStr = if (aStrTmp.contains(" ")) s"($aStrTmp)" else aStrTmp
    val res = List((a+b, s"$aStr + $b"), (a-b, s"$aStr - $b"),// (b-a, s"$b-$aStr"), 
      (a*b, s"$aStr * $b")) // not including b-a as that is covered by the permutation
    if (a %b ==0) res:+ (a/b, s"$aStr / $b") /* else if (b %a == 0) res:+ (b/a, s"$b / $aStr") */
    else res
  }

  def find24V3(four: List[Int]):List[(Int, String)] = {
    four.tail.foldLeft(List((four.head, four.head.toString))) { case (lst, num) =>
      lst.flatMap{x => allPossibleOpResultsV3(x, num)}}
      .filter(_._1 == 24)
  }
  def main(args: Array[String]):Unit = {
    val res = args.map(_.toInt).take(4).toList.permutations.map(find24V3(_)).filter(!_.isEmpty).toList
    res.flatten.map((_._2)).map(println)
  }
}
