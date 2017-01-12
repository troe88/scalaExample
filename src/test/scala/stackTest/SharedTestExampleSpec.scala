package stackTest

import Stack.Stack
import org.scalatest.{Tag, FlatSpec}
import specs.UnitSpec

/**
  * Created by Dmitry_Lebedev1 on 11-Jan-17.
  */

class SharedTestExampleSpec extends UnitSpec {

  // Stack fixture creation methods
  def emptyStack = new Stack[Int]

  def fullStack = {
    val stack = new Stack[Int]
    for (i <- 0 until stack.MAX)
      stack.push(i)
    stack
  }

  def stackWithOneItem = {
    val stack = new Stack[Int]
    stack.push(9)
    stack
  }

  def stackWithOneItemLessThanCapacity = {
    val stack = new Stack[Int]
    for (i <- 1 to 9)
      stack.push(i)
    stack
  }

  val lastValuePushed = 9

  "A Stack (when empty)" should "be empty" taggedAs TStack in {
    assert(emptyStack.empty)
  }

  it should "complain on peek" taggedAs TStack in {
    assertThrows[IllegalStateException] {
      emptyStack.peek
    }
  }

  it should "complain on pop" taggedAs TStack in {
    assertThrows[IllegalStateException] {
      emptyStack.pop
    }
  }

  "A Stack (with one item)"  should behave like nonEmptyStack(stackWithOneItem, lastValuePushed)

  it should behave like nonFullStack(stackWithOneItem)

  "A Stack (with one item less than capacity)" should behave like nonEmptyStack(stackWithOneItemLessThanCapacity, lastValuePushed)

  it should behave like nonFullStack(stackWithOneItemLessThanCapacity)

  "A Stack (full)" should "be full" taggedAs TStack in {
    assert(fullStack.full)
  }

  it should behave like nonEmptyStack(fullStack, lastValuePushed)

  it should "complain on a push" taggedAs TStack in {
    assertThrows[IllegalStateException] {
      fullStack.push(10)
    }
  }


}

object TStack extends Tag("TStack")