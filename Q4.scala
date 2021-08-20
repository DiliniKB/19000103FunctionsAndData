

class Acc(id:String, n:Int, b:Double){
  val nic:String = id
  val acnumber:Int = n
  var balance:Double = b

  def withdraw(a:Double) = this.balance -= a

  def deposit(a:Double) = this.balance += a

  def transfer(a:Acc, b:Double):Unit = {
    this.withdraw(b)
    a.deposit(b)
  }

  override def toString = "[" + this.nic + ":" + this.acnumber + ":" + this.balance + "]"
}
object Q4{
  def main(args:Array[String]):Unit = {
    val acc1 = new Acc("10V", 1, 250)
    val acc2 = new Acc("11V", 2, 500)
    val acc3 = new Acc("12V", 3, -1000)
    val acc4 = new Acc("13V", 4, 2200)
    val acc5 = new Acc("14V", 5, 10000)
    val acc6 = new Acc("15V", 6, -5000)

    var bank:List[Acc] = List(acc1, acc2, acc3, acc4, acc5, acc6)

    println("Overdraft Acc List")
    overdraft(bank).foreach(i => println(i))
    println()

    println("Sum of All Accs: Rs " + Totalbalance(bank))
    println()

    println("Sum of All Accs(After Interest): Rs " + Totalbalance(interest(bank)))
    println()
  }

  val overdraft = (b:List[Acc]) => b.filter(x => x.balance < 0)

  val Totalbalance = (b:List[Acc]) => b.reduce((x, y) => new Acc("", 0, x.balance + y.balance)).balance

  val interest = (b:List[Acc]) => b.map(x => if(x.balance >=0) new Acc(x.nic, x.acnumber, x.balance + x.balance * 0.005) else new Acc(x.nic, x.acnumber, x.balance + x.balance * 0.01))
}