package specs

/**
  * Created by Dmitry_Lebedev1 on 11-Jan-17.
  */
import org.scalatest._
import stackTest.StackBehaviors

trait UnitSpec extends FlatSpec with Matchers with
  OptionValues with Inside with Inspectors with BeforeAndAfter with StackBehaviors with GivenWhenThen