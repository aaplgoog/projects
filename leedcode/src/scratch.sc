val lst = List(1,1,2,2,3,3,3,3,3,3,4,4,5,5,5,5,1,1,2,2,3,4,4)
//lst.foldLeft(List.empty[(Int, Int)]){case (l, i) => }
lst.tail.foldLeft(List((lst.head, 1))){case (l, i)=> if(l.head._1 == i) (l.head._1, l.head._2 +1)+:l.tail
else (i, 1)+: l}.reverse

lst.groupBy(identity)


//List(1,2,3) +: List(2,3,4)
//List(1,2,3) :: List(2,3,4)
//List(1,2,3) ::: List(2,3,4)
//
//
//List(1,2,3,4).foldLeft(List.empty[Int]) { case (lst, num) => lst :+ num}
//
////Set((1, "one"), (2, "two")).find(_._1 == 1)
//List(2,4,6, 5).filter(_ %2 == 0)
//2.toString


val str = "we are the championion of the world, we go on fighting till the end"
str.split("\\W").filterNot(_ =="").foldLeft(Map.empty[String, Int]){case (m,s) => m + (s -> (m.getOrElse(s,0)+1))
}