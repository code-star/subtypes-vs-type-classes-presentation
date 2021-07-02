package example

object CompileProblemsWithSubTyping {

  //An example of that the compiler has problem understand code with to many dependencys.
  //The print-statement will not compile because of too many dependencies.
  //It might have been better model everything as a type-class accepting different kind of data
  //like data of type A, B, C, D and E.


  trait A extends B
  trait B extends C[D]
  trait C[T]
  trait E
  trait D extends E


  def f[T <: C[E]](x:T):Int = 17

  def main(args: Array[String]): Unit = {

    println((f[A](new A {})).asInstanceOf[C[E]])
  }



}
