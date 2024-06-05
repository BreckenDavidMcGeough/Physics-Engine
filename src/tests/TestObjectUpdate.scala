package tests
import org.scalatest._
import physics.PhysicsVector
import physics.objects.{DynamicObject, GameObject}
import physics.World
class TestObjectUpdate extends FunSuite {
  test(testName = "test objectUpdate"){
    val locationOne: PhysicsVector = new PhysicsVector(5.0,5.0,5.0)
    val copyLocationOne: PhysicsVector = new PhysicsVector(locationOne.x,locationOne.y,locationOne.z)
    val dimensionOne: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val velocityOne: PhysicsVector = new PhysicsVector(0.0,0.0,0.0)
    val dynObjectOne: DynamicObject = new DynamicObject(locationOne,dimensionOne)
    dynObjectOne.velocity = velocityOne
    physics.PhysicsEngine.updateObject(dynObjectOne,1.0,2.0)
    assert(dynObjectOne.onGroundCalled==false)
    assert(dynObjectOne.location != copyLocationOne)
    assert(dynObjectOne.velocity.z != 0)
    assert(dynObjectOne.location.z > 0)
    assert(dynObjectOne.location.z != dynObjectOne.previousLocation.z)
    assert(dynObjectOne.previousLocation.x == copyLocationOne.x)
    assert(dynObjectOne.previousLocation.y == copyLocationOne.y)
    assert(dynObjectOne.previousLocation.z == copyLocationOne.z)


    val locationTwo: PhysicsVector = new PhysicsVector(2.0,2.0,.1)
    val copyLocationTwo: PhysicsVector = new PhysicsVector(locationTwo.x,locationTwo.y,locationTwo.z)
    val dimensionTwo: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val velocityTwo: PhysicsVector = new PhysicsVector(1.0,2.0,1.0)
    val dynObjectTwo: DynamicObject = new DynamicObject(locationTwo,dimensionTwo)
    dynObjectTwo.velocity = velocityTwo
    physics.PhysicsEngine.updateObject(dynObjectTwo,.1,20.0)
    assert(dynObjectTwo.onGroundCalled==true)
    assert(dynObjectTwo.location != copyLocationTwo)
    assert(dynObjectTwo.velocity.z == 0)
    assert(dynObjectTwo.previousLocation.x == copyLocationTwo.x)
    assert(dynObjectTwo.previousLocation.z == copyLocationTwo.z)

    val locThree: PhysicsVector = new PhysicsVector(2.0,2.0,2.0)
    val copyLoc: PhysicsVector = new PhysicsVector(locThree.x,locThree.y,locThree.z)
    val dimThree: PhysicsVector = new PhysicsVector(1.0,1.0,1.0)
    val velocityThree: PhysicsVector = new PhysicsVector(-1.0,-1.0,-1.0)
    val dynoObjThree: DynamicObject = new DynamicObject(locThree,dimThree)
    dynoObjThree.velocity = velocityThree
    physics.PhysicsEngine.updateObject(dynoObjThree,2.0,15.0)
    assert(dynoObjThree.onGroundCalled == true)
    assert(dynoObjThree.previousLocation.z > 0)
    assert(dynoObjThree.location.z == 0)
    assert(dynoObjThree.velocity.z == 0)
    assert(dynoObjThree.previousLocation.z != dynoObjThree.location.z)


  }
}
