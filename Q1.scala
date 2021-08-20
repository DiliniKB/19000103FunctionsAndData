object Q1{
  def main(args:Array[String]):Unit = {
    val x = new Rational(9, 3)
    println(x)
    println(x.neg)
  }
}

class Rational(x:Int, y:Int){

  private def gcd(x:Int, y:Int):Int = if(y == 0) x else gcd(y, x % y)

  private val g = gcd(Math.abs(x), Math.abs(y))
  val n = x / g
  val d = y / g

  def neg = new Rational(- this.n, this.d)

  override def toString = this.n.toString + " / " + this.d.toString
}