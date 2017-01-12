package service

/**
  * Created by Dmitry_Lebedev1 on 12-Jan-17.
  */
import javax.inject.Inject
import play.api.libs.json.JsValue
import play.api.libs.ws.WSClient
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import scala.concurrent.Future

class GitHubClient(ws: WSClient, baseUrl: String) {
  @Inject def this(ws: WSClient) = this(ws, "https://api.github.com")

  def users(user:String): Future[JsValue] = {
    ws.url(baseUrl + "/" + "users/" + user).get().map { response =>
      response.json
    }
  }

  def repositories(): Future[Seq[String]] = {
    ws.url(baseUrl + "/repositories").get().map { response =>
      (response.json \\ "full_name").map(_.as[String])
    }
  }
}