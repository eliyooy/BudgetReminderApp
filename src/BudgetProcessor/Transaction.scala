package BudgetProcessor

/**
  * Created by eliyahudorsky on 5/29/16.
  */
class Transaction(val name: String, val value: Double, val special: Boolean) {
  var transactionName: String = name
  var transactionValue: Double = value
  var isSpecial: Boolean = special

  def setIsSpecial(special: Boolean): Unit = {
    isSpecial = special
  }

}
