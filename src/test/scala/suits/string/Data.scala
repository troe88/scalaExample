package suits.string

/**
  * Created by Dmitry_Lebedev1 on 11-Jan-17.
  */
trait Data {
  def stringWithDigit =
    new {
      val main = "qwe123asd"
      val sub  = "123"
      val start = "qwe"
      val end = "asd"
    }

  def stringWithCharacterOnly =
    new {
      val main = "qweasd"
      val sub  = "qwe"
      val start = "qwe"
      val end = "asd"
    }

  def containsMap =
  new {
    val data = Map(
      "qwe1" -> Array("q", "w", "e", "1"),
      "!@#$" -> Array("!", "@", "#", "$")
    )
  }
}
