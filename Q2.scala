object Q2{
  def main(args:Array[String]):Unit = {
    val x = new Rational2(3, 4)
    val y = new Rational2(5, 8)
    val z = new Rational2(2, 7)
    println(x.sub(y).sub(z))
  }
}

class Rational2(x:Int, y:Int){

  private def gcd(x:Int, y:Int):Int = if(y == 0) x else gcd(y, x % y)

  private val g = gcd(Math.abs(x), Math.abs(y))
  val numer = x / g
  val denom = y / g

  def neg = new Rational2(- this.numer, this.denom)

  def +(num:Rational2):Rational2 = {
    new Rational2(this.numer * num.denom + num.numer * this.denom, this.denom * num.denom)
  }

  def sub(num:Rational2):Rational2 = {
    this + num.neg
  }

  override def toString = this.numer.toString + " / " + this.denom.toString
}