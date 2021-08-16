package com.example.baeldungscala.classesobjects

import org.junit.jupiter.api.{Assertions, Test}

class _8_CompanionObject_UsedForFactoryMethodsTest {

  @Test
  def shouldCreateInstance_usingFactory = {
    import DeploymentEnvironment._

    val test = DeploymentEnvironment.fromEnvironment("test")
    val int = DeploymentEnvironment.fromEnvironment("int")
    val stg = DeploymentEnvironment.fromEnvironment("staging")
    val prd = DeploymentEnvironment.fromEnvironment("production")

    Assertions.assertEquals(Some(TestEnvironment()), test)
    Assertions.assertEquals(Some(IntEnvironment()), int)
    Assertions.assertEquals(Some(StagingEnvironment()), stg)
    Assertions.assertEquals(Some(ProductionEnvironment()), prd)
  }

  sealed class DeploymentEnvironment extends Serializable {
    val name: String = "int"
  }

  object DeploymentEnvironment {
    case class ProductionEnvironment() extends DeploymentEnvironment { override val name: String = "production" }
    case class StagingEnvironment() extends DeploymentEnvironment { override val name: String = "staging" }
    case class IntEnvironment() extends DeploymentEnvironment { override val name: String = "int" }
    case class TestEnvironment() extends DeploymentEnvironment { override val name: String = "test" }

    def fromEnvironment(env: String): Option[DeploymentEnvironment] = {
      env.toLowerCase match {
        case "int" => Some(IntEnvironment())
        case "staging" => Some(StagingEnvironment())
        case "production" => Some(ProductionEnvironment())
        case "test" => Some(TestEnvironment())
        case e =>
          println(s"Unknown environment $e")
          None
      }
    }
  }

}
