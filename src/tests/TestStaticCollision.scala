package tests
import org.scalatest._
import physics.PhysicsVector
import physics.objects.{DynamicObject, StaticObject}
class TestStaticCollision extends FunSuite {
  test(testName = "test static collisions"){
    val locationOne: PhysicsVector = new PhysicsVector(0.0,0.0,0.0)
    val dimensionOne: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val locationTwo: PhysicsVector = new PhysicsVector(.5,.5,.9)
    val dimensionTwo: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val previousLocationOne: PhysicsVector = new PhysicsVector(.5,.5,1.1)
    val statObjOne: StaticObject = new StaticObject(locationOne,dimensionOne)
    val dynObjOne: DynamicObject = new DynamicObject(locationTwo,dimensionTwo)
    dynObjOne.previousLocation.x = previousLocationOne.x
    dynObjOne.previousLocation.y = previousLocationOne.y
    dynObjOne.previousLocation.z = previousLocationOne.z
    physics.PhysicsEngine.checkStaticCollision(statObjOne,dynObjOne)
    assert(statObjOne.collideWithDynamicObjectCalled==true)
    assert(dynObjOne.collideWithStaticObjectCalled==true)
    assert(dynObjOne.collideWithDynamicObjectCalled==false)
    assert(dynObjOne.staticObject == statObjOne)
    assert(dynObjOne.staticObject != null)
    assert(statObjOne.otherObject == dynObjOne)
    assert(statObjOne.otherObject != null)
    //assert(dynObjOne.face == -1)
    assert(statObjOne.face == 1)
    
    

    val locationThree: PhysicsVector = new PhysicsVector(0.0,0.0,0.0)
    val dimensionThree: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val statObjTwo: StaticObject = new StaticObject(locationThree,dimensionThree)
    val locationFour: PhysicsVector = new PhysicsVector(-.4,.3,.6)
    val dimensionFour: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val previousLocationTwo: PhysicsVector = new PhysicsVector(-1.1,.1,.8)
    val dynObjTwo: DynamicObject = new DynamicObject(locationFour,dimensionFour)
    dynObjTwo.previousLocation.x = previousLocationTwo.x
    dynObjTwo.previousLocation.y = previousLocationTwo.y
    dynObjTwo.previousLocation.z = previousLocationTwo.z
    physics.PhysicsEngine.checkStaticCollision(statObjTwo,dynObjTwo)
    assert(statObjTwo.collideWithDynamicObjectCalled==true)
    assert(dynObjTwo.collideWithStaticObjectCalled==true)
    assert(dynObjTwo.collideWithDynamicObjectCalled==false)
    assert(dynObjTwo.staticObject == statObjTwo)
    assert(statObjTwo.otherObject == dynObjTwo)
    
    //if problem comment out
    assert(dynObjTwo.face == -1)
    
    
    //assert(statObjTwo.face == 1)
    
    
    val l4: PhysicsVector = new PhysicsVector(0.0,0.0,0.0)
    val d4: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val sO: StaticObject = new StaticObject(l4,d4)
    
    val l5: PhysicsVector = new PhysicsVector(-.9,-.4,.3)
    val d5: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val sD: DynamicObject = new DynamicObject(l5,d5)
    
    sD.previousLocation.x = .5
    sD.previousLocation.y = -.2
    sD.previousLocation.z = .8

    physics.PhysicsEngine.checkStaticCollision(sO,sD)
    assert(sO.collideWithDynamicObjectCalled==true)
    assert(sD.collideWithStaticObjectCalled==true)
    assert(sD.collideWithDynamicObjectCalled==false)
    assert(sD.staticObject == sO)
    assert(sO.otherObject == sD)
    assert(sD.face == -1)
    //assert(sO.face == 1)


    val l6: PhysicsVector = new PhysicsVector(0.0,0.0,0.0)
    val d6: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val sO2: StaticObject = new StaticObject(l6,d6)

    val l7: PhysicsVector = new PhysicsVector(-.4,.3,.6)
    val d7: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val sD2: DynamicObject = new DynamicObject(l7,d7)

    sD2.previousLocation.x = -1.1
    sD2.previousLocation.y = .1
    sD2.previousLocation.z = .8

    physics.PhysicsEngine.checkStaticCollision(sO2,sD2)
    assert(sO2.collideWithDynamicObjectCalled==true)
    assert(sD2.collideWithStaticObjectCalled==true)
    assert(sD2.collideWithDynamicObjectCalled==false)
    assert(sD2.staticObject == sO2)
    assert(sD2.otherObject == null)
    assert(sO2.otherObject == sD2)
    assert(sD2.face == -1)
    //assert(sO2.face == 1)
    
    
    val l9: PhysicsVector = new PhysicsVector(0.0,0.0,0.0)
    val d9: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val s9: StaticObject = new StaticObject(l9,d9)
    
    val l10: PhysicsVector = new PhysicsVector(-.9,-.4,.3)
    val d10: PhysicsVector = new PhysicsVector(-1.0,-1.0,1.0)
    val do9: DynamicObject = new DynamicObject(l10,d10)
    
    do9.previousLocation.x = -1.1
    do9.previousLocation.y = -.2
    do9.previousLocation.z = .8 
    
    physics.PhysicsEngine.checkStaticCollision(s9,do9)
    
    assert(s9.collideWithDynamicObjectCalled==false)
    assert(do9.collideWithDynamicObjectCalled==false)
    assert(do9.collideWithStaticObjectCalled==false)
    assert(do9.staticObject!=s9)
    assert(do9.staticObject == null)
    assert(s9.otherObject == null)
    assert(s9.otherObject!=do9)
    assert(do9.face == -1)
    assert(s9.face == -1)
    assert(s9.otherObject == null)
    assert(do9.staticObject == null)
    
    


  }
}
