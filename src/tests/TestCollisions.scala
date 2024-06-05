package tests

import org.scalatest._
import physics.{PhysicsEngine, PhysicsVector, World, objects}
import physics.objects.{DynamicObject, GameObject, StaticObject}

class TestCollisions extends FunSuite {


  test("Tests for accurate collision detection between two objects") {
    
    val l1: PhysicsVector = new PhysicsVector(-2.3,-4.2,-.6)
    val d1: PhysicsVector = new PhysicsVector(-1.0,-3.4,-6.5)
    val o1: GameObject = new GameObject(l1,d1)
    //2nd part
    val l2: PhysicsVector = new PhysicsVector(-1.2,-8.3,-4.0)
    val d2: PhysicsVector = new PhysicsVector(-1.0,-0.0,-1.23)
    val o2: GameObject = new GameObject(l2,d2)
    
    assert(physics.PhysicsEngine.isCollision(o1,o2) == false)
    
    val locationOne = new PhysicsVector(0.0, 0.0, 0.0)
    val dimensionOne = new PhysicsVector(1.0, 1.0, 1.0)
    val objOne = new GameObject(locationOne,dimensionOne)
    val locationTwo = new PhysicsVector(0.0, 0.0, 0.0)
    val dimensionTwo = new PhysicsVector(1.0, 2.0, 5.0)
    val objTwo = new GameObject(locationTwo,dimensionTwo)
    assert(physics.PhysicsEngine.isCollision(objOne,objTwo) == true)

    val locationThree = new PhysicsVector(-1.0,-2.0,-3.0)
    val dimensionThree = new PhysicsVector(1.0,2.0,3.0)
    val objThree = new GameObject(locationThree,dimensionThree)
    val locationFour = new PhysicsVector(0.0,0.0,0.0)
    val dimensionFour = new PhysicsVector(3.0,2.5,1.0)
    val objFour = new GameObject(locationFour,dimensionFour)
    assert(physics.PhysicsEngine.isCollision(objThree,objFour)==false)

    val locationFive: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val dimensionFive: PhysicsVector = new PhysicsVector(1.5,1.5,1.5)
    val objFive: GameObject = new GameObject(locationFive,dimensionFive)
    val locationSix: PhysicsVector = new PhysicsVector(2.0,2.0,2.0)
    val dimensionSix: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val objSix: GameObject = new GameObject(locationSix,dimensionSix)
    assert(physics.PhysicsEngine.isCollision(objFive,objSix)==true)

    val locationNine: PhysicsVector = new PhysicsVector(3.0,0.0,0.0)
    val dimensionNine: PhysicsVector = new PhysicsVector(.1,0.0,0.0)
    val objNine: GameObject = new GameObject(locationNine,dimensionNine)
    val locationTen: PhysicsVector = new PhysicsVector(2.0,0.0,0.0)
    val dimensionTen: PhysicsVector = new PhysicsVector(1.5,0.0,0.0)
    val objTen: GameObject = new GameObject(locationTen,dimensionTen)
    assert(physics.PhysicsEngine.isCollision(objNine,objTen)==false)

    val locationEleven: PhysicsVector = new PhysicsVector(3.0,4.0,0.0)
    val dimensionEleven: PhysicsVector = new PhysicsVector(.1,.1,5.0)
    val objEleven: GameObject = new GameObject(locationEleven,dimensionEleven)
    val locationTwelve: PhysicsVector = new PhysicsVector(2.0,2.0,4.5)
    val dimensionTwelve: PhysicsVector = new PhysicsVector(1.5,2.5,.1)
    val objTwelve: GameObject = new GameObject(locationTwelve,dimensionTwelve)
    assert(physics.PhysicsEngine.isCollision(objEleven,objTwelve) == true)

    val locationThirt: PhysicsVector = new PhysicsVector(1.0,0.0,3.0)
    val dimensionThirt : PhysicsVector = new PhysicsVector(1.0,0.0,1.0)
    val objThirt: GameObject = new GameObject(locationThirt,dimensionThirt)
    val locationFourt: PhysicsVector = new PhysicsVector(2.0,0.0,3.5)
    val dimensionFourt: PhysicsVector = new PhysicsVector(1.0,0.0,1.0)
    val objFourt: GameObject = new GameObject(locationFourt,dimensionFourt)
    assert(physics.PhysicsEngine.isCollision(objThirt,objFourt)==false)

    val locationFift: PhysicsVector = new PhysicsVector(1.0,0.0,3.0)
    val dimensionFift: PhysicsVector = new PhysicsVector(2.0,1.0,4.0)
    val objFift: GameObject = new GameObject(locationFift,dimensionFift)
    val locationSixt: PhysicsVector = new PhysicsVector(1.0,0.0,3.5)
    val dimensionSixt: PhysicsVector = new PhysicsVector(2.0,0.0,1.0)
    val objSixt: GameObject = new GameObject(locationSixt,dimensionSixt)
    assert(physics.PhysicsEngine.isCollision(objFift,objSixt) == false)

    val locO: PhysicsVector = new PhysicsVector(5.0,4.0,0.0)
    val dimO: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val objO: GameObject = new GameObject(locO,dimO)
    val locT: PhysicsVector = new PhysicsVector(5.5,4.5,1.5)
    val dimT: PhysicsVector = new PhysicsVector(2.0,2.0,-1.0)
    val objT: GameObject = new GameObject(locT,dimT)
    assert(physics.PhysicsEngine.isCollision(objO,objT)==false)
    assert(physics.PhysicsEngine.isCollision(objT,objO)==false)

    //already tried negative a1 and a2 with postive a2 and b2 where collision is true, didnt pass Lq
    //
    
    val a1: PhysicsVector = new PhysicsVector(-1.0,-1.0,-1.0)
    val a2: PhysicsVector = new PhysicsVector(2.0,2.0,2.0)
    val a3: GameObject = new GameObject(a1,a2)
    
    val b1: PhysicsVector = new PhysicsVector(-1.5,-1.5,-1.5)
    val b2: PhysicsVector = new PhysicsVector(2.0,2.0,2.0)
    val b3: GameObject = new GameObject(b1,b2)
    
    assert(physics.PhysicsEngine.isCollision(a3,b3)==true)
  }
}
