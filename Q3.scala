object Q3{
  def main(args:Array[String]):Unit = {
    val acc1 = new Account("10V", 20, 11000)
    val acc2 = new Account("11V", 25, 900)

    println("Before Transfer")
    println(acc1)
    println(acc2)

    println()
    acc1.transfer(acc2, 100)

    println("After Transfer")
    println(acc1)
    println(acc2)
  }
}

class Account(id:String, n:Int, b:Double){
  val nic:String = id
  val acnumber:Int = n
  var balance:Double = b

  def withdraw(a:Double) = this.balance -= a

  def deposit(a:Double) = this.balance += a

  def transfer(a:Account, b:Double):Unit = {
    this.withdraw(b)
    a.deposit(b)
  }

  override def toString = "[" + this.nic + ":" + this.acnumber + ":" + this.balance + "]"
}