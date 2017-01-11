package suits

/**
  * Created by Dmitry_Lebedev1 on 11-Jan-17.
  */

import org.scalatest._
import scala.collection.mutable.Stack

object Tag1 extends Tag("Tag1")
object Tag2 extends Tag("Tag2")
object Tag3 extends Tag("Tag3")

class Test extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" taggedAs Tag1 in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  "Numbers" should "comparable with each other" taggedAs Tag2 in {
    val a = 1
    val b = 1
    val c = 5
    val d = 4
    assert(a == b || c >= d)
  }


  "Numbers" should "shape as well" taggedAs Tag2 in {
    val xs = 2 :: 2 :: 1 :: 1 :: Nil
    Assertions.assert(xs.forall(i => i > 0))
  }

  "User" should "get message from server" taggedAs Tag3 in {
    assert("message".endsWith("e"));
    assert("message".startsWith("m"))
    assert("message".length === 7)
  }

}


