package example

import cats.Eq

object CatsTypeClasses {

  //An example of overriding a primitive type by using type-classes
  //Cats have a lot of type-classes and instances you can use.
  //Here we use Eq, but you can also use Monoid and other from cats


  def main(args: Array[String]): Unit = {


    implicit val eqInt: Eq[Int] = new Eq[Int] {

      def eqv(x: Int, y: Int): Boolean = false
    }

    import cats.instances.int._

   // val eqInt = Eq[Int]

    println( eqInt.eqv(2,2) )

//    import cats.instances.string._
//    val eqString = Eq[String]
//    println( eqString.eqv("2","2") )
//    println( eqString.eqv("a","b") )
  }
}