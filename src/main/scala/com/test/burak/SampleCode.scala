package com.test.burak

object SampleCode extends SampleCodeTrait {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }

    //tail recursive call:
    println(sum(x => x * x, 3, 5))
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == r || c == 0) 1
    else if (c > r) throw new Exception("It's not defined for Pascal Triangle (row cannot be higher than column)")
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    val onlyP = chars.filter(i => i.equals('(') || i.equals(')'))
    if (onlyP.head == ')') false
    else if (onlyP.last == '(') false
    else if (chars.isEmpty) throw new Exception("List is empty")
    else {
      val calc = onlyP.map(word => (word, 1)).groupBy(i => i._1).map { i =>
        (i._1, i._2.length)
      }
      if (calc.head == calc.last) false
      else calc.head._2 == calc.last._2
    }
  }

  /**
    * Calculates number if changes
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def loop(money: Int, coins: List[Int]): Int = {
      if (money < 0 || coins.isEmpty) 0
      else if (money == 0) 1
      else loop(money, coins.tail) + loop(money - coins.head, coins)
    }

    loop(money, coins)
  }

  // tail recursive example:
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }

    loop(a, 0)
  }

}
