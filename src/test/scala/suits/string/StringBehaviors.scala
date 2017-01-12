package suits.string

import org.scalatest.GivenWhenThen
import specs.UnitSpec

/**
  * Created by Dmitry_Lebedev1 on 11-Jan-17.
  */
trait StringBehaviors {
  this: UnitSpec =>
  def containsSubstring(main: String, sub: String): Unit = {
    it should "contains substring" taggedAs TString in {
      main should include (sub)
    }
  }

  def startSubstring(main: String, start: String): Unit = {
    it should "start with string" taggedAs TString in {
      main should startWith (start)
    }
  }

  def endSubstring(main: String, end: String): Unit = {
    it should "end with string" taggedAs TString in {
      main should endWith (end)
    }
  }

}
