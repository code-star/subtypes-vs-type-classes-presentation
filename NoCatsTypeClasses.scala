package example

object NoCatsTypeClasses {

  trait Eq[A] {
    def areEquals(a: A, b: A): Boolean
  }

  implicit object eqDouble extends Eq[Double] {
    override def areEquals(value1: Double, value2: Double): Boolean =
      if(value1 < value2 + 0.01 && value2 < value1 + 0.01) true else false
  }


  implicit object eqList extends Eq[List[Double]] {
     override def areEquals(value1: List[Double], value2: List[Double]): Boolean =
     { value1.zip(value2).map{ case(a,b) => eqDouble.areEquals(a,b) }.foldRight(true){(a,b) => a && b}}
  }

  def pairEquals[A](a: A, b: A)(implicit eq: Eq[A]): Option[(A,A)] = {
    if(eq.areEquals(a,b)) Some((a,b)) else None
  }


  def main(args: Array[String]): Unit = {

     println( "test1 = " +  pairEquals(1.0001, 1.0002))
    println( "test2 = " +  pairEquals(1.2, 1.3))

    println( "test3 = " +  pairEquals(List(1.0001, 1.0002),List(1.0001, 1.0002) ))
    println( "test4 = " +  pairEquals(List(2.0001, 2.0002),List(1.0001, 1.0002)) )
  }
}