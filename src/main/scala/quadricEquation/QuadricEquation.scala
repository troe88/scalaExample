package quadricEquation

/**
  * Created by Dmitry_Lebedev1 on 12-Jan-17.
  */

class NegativeDiscriminantException extends Exception;

class QuadricEquation(var _a:Double, var _b:Double, var _c:Double) {

  // ax^2 + bx + c = 0
  // D = b^2 - 4ac
  // x1,2 = (-b +- sqrt(d)) / 2a

  private var d:Double = 0.0
  private var x12:Array[Double] = new Array[Double](2);

  private def D() : Double = {
    math.pow(_b, 2) - 4 * _a * _c
  }

  private def X(d:Double) : Double = {
    (-_b + d) / (2 * _a)
  }

  private def scale(arg: Double): Double = {
    math.BigDecimal(arg).setScale(1, math.BigDecimal.RoundingMode.DOWN).doubleValue()
  }

  def calculate(): Array[Double] = {
    d = D()
//    if(d < 0)
//      throw new NegativeDiscriminantException();
    val sqrt_d = math.sqrt(d);
    x12(0) = X(sqrt_d)
    x12(1) = X(-sqrt_d)
    x12.map(f => scale(f))
  }

}
