package stackTest

import Stack.Stack
import org.scalatest.FlatSpec
import specs.UnitSpec

/**
  * Created by Dmitry_Lebedev1 on 11-Jan-17.
  */

trait StackBehaviors { this: UnitSpec =>

  def nonEmptyStack(newStack: => Stack[Int], lastItemAdded: Int) {
    it should "be non-empty" taggedAs TStack in {
      assert(!newStack.empty)
    }

    it should "return the top item on peek" taggedAs TStack in {
      assert(newStack.peek === lastItemAdded)
    }

    it should "not remove the top item on peek" taggedAs TStack in {
      val stack = newStack
      val size = stack.size
      assert(stack.peek === lastItemAdded)
      assert(stack.size === size)
    }

    it should "remove the top item on pop" taggedAs TStack in {
      val stack = newStack
      val size = stack.size
      assert(stack.pop === lastItemAdded)
      assert(stack.size === size - 1)
    }
  }

  def nonFullStack(newStack: => Stack[Int]) {
    it should "not be full" taggedAs TStack in {
      assert(!newStack.full)
    }

    it should "add to the top on push" taggedAs TStack in {
      val stack = newStack
      val size = stack.size
      stack.push(7)
      assert(stack.size === size + 1)
      assert(stack.peek === 7)
    }
  }
}