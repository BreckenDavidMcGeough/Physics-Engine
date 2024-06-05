package model.playerstates.groundstates

import model.Player
import model.playerstates.PlayerState
import model.playerstates.airstates.Falling

abstract class OnGround(player: Player) extends PlayerState(player) {

  override def leftPressed(): Unit = {
    player.walkLeft()
    player.state = new Walking(player)
  }

  override def rightPressed(): Unit = {
    player.walkRight()
    player.state = new Walking(player)
  }

  override def falling(): Unit = {
    player.state = new Falling(player)
  }

}
