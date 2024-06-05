package model.game_objects

import physics.PhysicsVector
import physics.objects.{DynamicObject, Face}


class Wall(location: PhysicsVector, dimensions: PhysicsVector) extends JumperObject(location, dimensions){

  override def collideWithDynamicObject(otherObject: DynamicObject, face: Integer): Unit = {
    if(face == Face.negativeX){
      otherObject.velocity.x = 0.0
      otherObject.location.x = this.location.x - otherObject.dimensions.x
    }else if(face == Face.positiveX){
      otherObject.velocity.x = 0.0
      otherObject.location.x = this.location.x + this.dimensions.x
    }
  }

}
