package numbers

import org.scalatest.{Tag, BeforeAndAfter, Matchers, FlatSpec}

/**
  * Created by Dmitry_Lebedev1 on 11-Jan-17.
  */

class SimpleOperations extends FlatSpec with Matchers with BeforeAndAfter{

  var num1 : Int = 2
  var num2 : Int = 3
  var res  : Int = 0


  before {
    num1 = 2
    num2 = 3
  }

  after {
    num1 = 0
    num2 = 0
    res = 0
  }

  behavior of "simple numbers"

  it should "shape as well" taggedAs Numbers in {

  }

  it should "multiple as well" taggedAs Numbers in {

  }

  ignore should "divide as well" taggedAs Numbers in {

  }

  it must "be negative" taggedAs Numbers in {

  }

  it must "be positive" taggedAs Numbers in {

  }

}

object Numbers extends Tag("Numbers")