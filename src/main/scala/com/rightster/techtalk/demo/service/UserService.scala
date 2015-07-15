package com.rightster.techtalk.demo.service

/**
 * Created by antonvanco on 15/07/2015.
 */
trait UserService {
  def getUsers: Iterable[User]

  def getUserById(userId: String): Either[NonExistentUserException, User]

  def getLoggedInUsers: Iterable[User]
}

class NonExistentUserException(userId: String) extends Exception(s"User $userId does not exist")

trait Role {
  def isSuperUser: Boolean
  def id: Symbol
  override def toString: String = id.toString().replaceAll("'", "")
}

object Admin extends Role {
  val id = 'admin
  val isSuperUser = true
}

object RegisteredUser extends Role {
  val id = 'registeredUser
  val isSuperUser = false
}

object Guest extends Role {
  val id = 'guest
  val isSuperUser = false
}

case class User(id: String, role: Role, loggedIn: Boolean)
