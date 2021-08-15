package com.example.baeldungscala.classesobjects

import org.junit.jupiter.api.{Assertions, Test}

class _6_ScalaObjectsTest {

  @Test
  def shouldUseSingleton_andUse = {
    import Router._

    Assertions.assertNotNull(Response("base", "path", "GET"))
    Assertions.assertEquals("https://www.google.com", baseUrl)
    Assertions.assertEquals(get("/index"), Response("https://www.google.com", "/index", "GET"))
    Assertions.assertEquals(put("/index"), Response("https://www.google.com", "/index", "PUT"))
    Assertions.assertEquals(post("/scala-tutorials"), Response("https://www.google.com", "/scala-tutorials", "POST"))
  }

  object Router {
    var baseUrl: String = "https://www.google.com"

    case class Response(baseUrl: String, path: String, action: String)

    def get(path: String): Response = {
      Response(baseUrl, path, "GET")
    }

    def post(path: String): Response = {
      Response(baseUrl, path, "POST")
    }

    def patch(path: String): Response = {
      Response(baseUrl, path, "PATCH")
    }

    def put(path: String): Response = {
      Response(baseUrl, path, "PUT")
    }

    def delete(path: String): Response = {
      Response(baseUrl, path, "DELETE")
    }
  }

}
