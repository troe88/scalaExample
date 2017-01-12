package suits.string

import org.scalatest.Tag
import specs.UnitSpec

/**
  * Created by Dmitry_Lebedev1 on 11-Jan-17.
  */

object TString extends Tag("TString")


class StringTest extends UnitSpec with StringBehaviors with Data {

  behavior of "A string with digit"
  it should behave like containsSubstring(stringWithCharacterOnly.main, stringWithCharacterOnly.sub)
  it should behave like endSubstring(stringWithCharacterOnly.main, stringWithCharacterOnly.end)
  it should behave like startSubstring(stringWithCharacterOnly.main, stringWithCharacterOnly.start)

  behavior of "A string with character only"
  it should behave like containsSubstring(stringWithDigit.main, stringWithDigit.sub)
  it should behave like endSubstring(stringWithDigit.main, stringWithDigit.end)
  it should behave like startSubstring(stringWithDigit.main, stringWithDigit.start)

  behavior of "String concatenations"
  it must "consist of other strings" taggedAs TString in {
    forAll(containsMap.data) {
      case (a: String, b:Array[String]) =>
        Given(f"Expected string: $a, substrings: ${b.mkString(", ")}")
        When("Concatinate all strings")
        Then(f"String should be $a")
        a should equal(b.mkString(""))
    }
  }

}
