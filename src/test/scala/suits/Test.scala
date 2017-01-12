package suits

/**
  * Created by Dmitry_Lebedev1 on 11-Jan-17.
  */

import org.scalatest._
import specs.UnitSpec
import scala.collection.mutable.Stack

object Tag1 extends Tag("Tag1")
object Tag2 extends Tag("Tag2")
object Tag3 extends Tag("Tag3")


class Test extends UnitSpec {

  "A Stack" should "pop values in last-in-first-out order" taggedAs Tag1 in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack should equal (2 :: 1 :: 3 :: Nil)
    stack should have length  2
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


  it should "shape as well" taggedAs Tag2 in {
    val xs = 2 :: 2 :: 1 :: 1 :: Nil
    Assertions.assert(xs.forall(i => i > 0))
  }

  it should "multiply as well" taggedAs Tag2 in {

    info("info is recorded")
    markup("markup is *also* recorded")
    note("notes are sent immediately")
    alert("alerts are also sent immediately")

    assert(1 + 2 == 3)
  }

  "User" should "get message from server" taggedAs Tag3 in {
    assert("message".endsWith("e"));
    assert("message".startsWith("m"))
    assert("message".length === 7)
  }

}


