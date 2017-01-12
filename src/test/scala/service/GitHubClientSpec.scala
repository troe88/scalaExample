package service

import play.core.server.Server
import play.api.Play
import play.api.routing.sird._
import play.api.mvc._
import play.api.libs.json._
import play.api.test._
import specs.UnitSpec

import scala.collection.mutable.ListBuffer
import scala.concurrent.Await
import scala.concurrent.duration._

import org.specs2.mutable.Specification
import org.specs2.time.NoTimeConversions

import scala.concurrent.Await


/**
  * Created by Dmitry_Lebedev1 on 12-Jan-17.
  */
class GitHubClientSpec extends UnitSpec {

  def usersRepos =
    new {
      val data = Map(
        "troe88" -> Seq("lab2", "baly"),
        "Supreme85" -> Seq("allure-mstest-adapter", "htmlelements", "htmlelements-examples", "VIQAUITestingTool-Light")
      )
    }

  "GitHubClient" should "get all repositories of current user" in {
    forAll(usersRepos.data) {
      case (userName: String, expectedRepo: Seq[String]) => {
        WsTestClient.withClient { client =>
          val res = Await.result(new GitHubClient(client).users(userName + "/repos"), 10.seconds)
          val v = (res \\ "name").map(_.as[String])
//          expectedRepo.foreach(exp => assert(v.contains(exp)))
          v should contain allElementsOf expectedRepo
//          assert(v.containsSlice(expectedRepo))
        }
      }
    }
  }

}