package com.example.baeldungscala.classesobjects

import org.junit.jupiter.api.{Assertions, Test}

class _7_CompanionObjectTest {

  @Test
  def shouldInstantiateCompanionObject = {
    val indexRouter = new Router("/index")

    Assertions.assertEquals(Router.Response("https://www.google.com", "/index", "GET"), indexRouter.get)
    Assertions.assertEquals(Router.Response("https://www.google.com", "/index", "POST"), indexRouter.post)
  }

  object Router {
    var baseUrl: String = "https://www.google.com"

    case class Response(baseUrl: String, path: String, action: String)

    private def getAction(path: String): Response = {
      Response(baseUrl, path, "GET")
    }

    private def postAction(path: String): Response = {
      Response(baseUrl, path, "POST")
    }
  }

  class Router(path: String) {
    import Router._
    // Note: Companion classes can access the private methods of the objects
    def get: Response = getAction(path)
    def post: Response = postAction(path)
  }
}
