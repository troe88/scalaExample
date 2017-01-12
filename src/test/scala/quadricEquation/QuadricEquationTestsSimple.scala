package quadricEquation

import specs.UnitSpec

/**
  * Created by Dmitry_Lebedev1 on 12-Jan-17.
  */

class QuadricEquationTestsSimple extends UnitSpec {

  behavior of "Quadric equation"
  it should "solved with positive Discriminant" in {
    val res = new QuadricEquation(5, 6, 1).calculate()
    res should contain (-1)
    res should contain (-0.2)
  }

  it should "solved with zero Discriminant" in {
    val res = new QuadricEquation(9, 12, 4).calculate()
    res should equal (Array(-0.6, -0.6))
  }

  it should "produce NegativeDiscriminantException with negative Discriminant" in {
    assertThrows[NegativeDiscriminantException]{
      val res = new QuadricEquation(9, 2, 4).calculate()
    }
  }

}