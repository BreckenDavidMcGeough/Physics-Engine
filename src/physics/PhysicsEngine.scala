package physics

import physics.objects.{DynamicObject, GameObject, StaticObject,Face}

/**
  * Controls and computes the simulated physics for a game. Manages dynamic object movement, gravity, and
  * object collisions
  */
object PhysicsEngine {
  def updateObject(dynObj: DynamicObject,time: Double,gravity: Double): Unit= {
    dynObj.velocity.z = dynObj.velocity.z + -(gravity*time)
    val location_x: Double = dynObj.location.x
    val location_y: Double = dynObj.location.y
    val location_z: Double = dynObj.location.z
    dynObj.previousLocation.x = location_x
    dynObj.previousLocation.y = location_y
    dynObj.previousLocation.z = location_z
    dynObj.location.x = dynObj.location.x + dynObj.velocity.x*time
    dynObj.location.y = dynObj.location.y + dynObj.velocity.y*time
    dynObj.location.z = dynObj.location.z + dynObj.velocity.z*time
    if (dynObj.location.z <= 0.0){
      dynObj.location.z = 0.0
      dynObj.velocity.z = 0.0
      dynObj.onGround()
    }
  }
  def isCollision(one: GameObject, two: GameObject): Boolean ={
    var ifCO: Boolean = false
    val middleOfOne: PhysicsVector = new PhysicsVector(
      ((2*one.location.x+one.dimensions.x)/2),
      ((2*one.location.y+one.dimensions.y)/2),
      ((2*one.location.z+one.dimensions.z)/2)
    )
    val middleOfTwo: PhysicsVector = new PhysicsVector(
      ((2*two.location.x+two.dimensions.x)/2),
      ((2*two.location.y+two.dimensions.y)/2),
      ((2*two.location.z+two.dimensions.z)/2)
    )
    if(Math.abs(middleOfTwo.x-middleOfOne.x) < (two.dimensions.x+one.dimensions.x)/2 &&
    Math.abs(middleOfTwo.y-middleOfOne.y) < (two.dimensions.y+one.dimensions.y)/2 &&
    Math.abs(middleOfTwo.z-middleOfOne.z) < (two.dimensions.z+one.dimensions.z)/2) {
      if(one.location.x+one.dimensions.x > 0 && one.location.y+one.dimensions.y > 0 &&
      one.location.z+one.dimensions.z > 0 && two.location.x+two.dimensions.x > 0 &&
      two.location.y+two.dimensions.y > 0 && two.location.z+two.dimensions.z > 0){
        ifCO = true
      }
    }
    ifCO
  }
  def checkStaticCollision(statObj: StaticObject, dynObj: DynamicObject): Unit = {
    val checkCollision: Boolean = this.isCollision(statObj,dynObj)
    if (checkCollision == true){
      if(dynObj.previousLocation.z < statObj.location.z){
        dynObj.collideWithStaticObject(statObj)
        statObj.collideWithDynamicObject(dynObj,Face.bottom)
      }else{
        if(dynObj.previousLocation.z > statObj.location.z){
          dynObj.collideWithStaticObject(statObj)
          statObj.collideWithDynamicObject(dynObj,Face.top)
        }else{
          if(dynObj.previousLocation.x > statObj.location.x){
            dynObj.collideWithStaticObject(statObj)
            statObj.collideWithDynamicObject(dynObj, Face.positiveX)
          }else{
            if(dynObj.previousLocation.x < statObj.location.x){
              dynObj.collideWithStaticObject(statObj)
              statObj.collideWithDynamicObject(dynObj, Face.negativeX)
            }else{
              if(dynObj.previousLocation.y > statObj.location.y){
                dynObj.collideWithStaticObject(statObj)
                statObj.collideWithDynamicObject(dynObj, Face.positiveY)
              }else{
                if(dynObj.previousLocation.y < statObj.location.y){
                  dynObj.collideWithStaticObject(statObj)
                  statObj.collideWithDynamicObject(dynObj, Face.negativeY)
                }
              }
            }
          }
        }
      }

    }
  }
  def updateWorld(world: World, dt: Double): Unit = {
    for(dynObj <- world.dynamicObjects){
      this.updateObject(dynObj,dt,world.gravity)
      for(statObj <- world.staticObjects) {
        this.checkStaticCollision(statObj, dynObj)
      }
    }
  }

}
