package BudgetProcessor
import scala.collection.mutable.ArrayBuffer

/**
  * Created by eliyahudorsky on 5/29/16.
  */
class BudgetArea(val limit : Double, val priority : Int) {

  var budgetLimit: Double = limit
  var priorityLevel: Int = priority

  var totalSpent: Double = 0.0
  var transactions: ArrayBuffer[Transaction] = new ArrayBuffer[Transaction]()

  def performTransaction( name : String, value : Double, special: Boolean ): Transaction = {
    val newTransaction = new Transaction(name, value, special)
    if((totalSpent + value) > budgetLimit && !newTransaction.isSpecial) {
      throw IllegalTransaction("You have exceeded the budget limit for this area.")
    } else {
      totalSpent += value
      transactions += newTransaction
    }
    return newTransaction
  }

  def setBudgetLimit(newLimit: Double): String = {
    budgetLimit == newLimit
    if(budgetLimit >= totalSpent) {
      throw OverrageSpending("You have exceeded this limit for the month by " + (totalSpent - budgetLimit) + ".")
    } else {
      return "New budget limit set."
    }
  }

  case class IllegalTransaction(message: String) extends Exception(message)
  case class OverrageSpending(message: String) extends Exception(message)

}
