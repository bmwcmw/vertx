package gatling.scenarios

import com.databerries.gatling.Constants
import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._

import scala.util.Random

object JsonWrongRequest {
  val endPoint = List(JsonEndpoint.uri, RawEndpoint.uri)
  private val name = "Wrong request"

  val req: ChainBuilder = exec(
    http(name)
      .post(Random.shuffle(endPoint).head)
      .body(ElFileBody("request_bad.json")).asJSON
  )

  val scenario: ScenarioBuilder = Constants.createBidderScenario(name, req)
}
