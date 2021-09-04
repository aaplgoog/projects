def allPossibleOpResultsV3(aPair:(Int, String), b:Int):List[(Int, String)] = {
  val (a,aStrTmp) = aPair
  val aStr = if (aStrTmp.contains(" ")) s"($aStrTmp)" else aStrTmp
  val res = List((a+b, s"$aStr + $b"), (a-b, s"$aStr - $b"),
    (a*b, s"$aStr * $b")) // not including b-a as that is covered by the permutation
  if (a %b ==0) res:+ (a/b, s"$aStr / $b") else res
}

def find24V3(four: List[Int]):List[(Int, String)] = {
  four.tail.foldLeft(List((four.head, four.head.toString))) { case (lst, num) =>
    lst.flatMap{x => allPossibleOpResultsV3(x, num)}}
    .filter(_._1 == 24)
}

val res = List(11,11,7,12).permutations.map(find24V3(_)).filter(!_.isEmpty).toList

println("Num of solutions: " + res.length)
res.flatten.map((_._2)).map(println)

//val four = List(8, 4, 9, 2)// List(7,2,1,10)
//println(four)
////val take2 = four.toSet.subsets().filter(_.size == 2)
//val take2 = four.combinations(2)
////Set(1,2).subsetOf(four.toSet)
//take2.toList

/*

four.permutations.toList.mkString("\n")

def allPossibleOpResults(a:Int, b:Int):List[Int] = {
  val res = List(a+b, a-b, a*b) // not including b-a as that is covered by the permutation
  if (a %b ==0) res:+ (a/b) else res
}

def allPossibleOpResults2(a:Int, b:Int):List[(Int, String)] = {
  val res = List((a+b, s"$a + $b"), (a-b, s"$a - $b"), (a*b, s"$a * $b")) // not including b-a as that is covered by the permutation
  if (a %b ==0) res:+ (a/b, s"$a / $b") else res
}
allPossibleOpResults2(4,2)


def find24(four: List[Int]):Boolean = {
  four.tail.foldLeft(List(four.head)) { case (lst, num) =>
    lst.flatMap(allPossibleOpResults(_, num))
  }.toSet.contains(24)
}

def find24V2(four: List[Int]):List[(Int, String)] = {
  four.tail.foldLeft(List((four.head, ""))) { case (lst, num) =>
    lst.flatMap{x => allPossibleOpResults2(x._1, num)}}
    .filter(_._1 == 24)//.isDefined
//    lst.flatMap(allPossibleOpResults2(_._1, num))
//  }.toSet.contains(24)
}



//four.permutations.find(find24(_)).toList
//four.permutations.map(find24V2(_)).filter(!_.isEmpty).toList
*/















//def splitPairAndRest(nums: Set[Int], pair:Set[Int]):(Set[Int], Set[Int])
//= {
//  assert(pair.subsetOf(nums))
//
//
//}




