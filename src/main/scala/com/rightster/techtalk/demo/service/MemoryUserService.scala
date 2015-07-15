package com.rightster.techtalk.demo.service

/**
 * Created by antonvanco on 15/07/2015.
 */
class MemoryUserService(userIdProvider: UserIdProvider) extends UserService {
  val users = Seq(
    User(userIdProvider.getUserId, Admin, loggedIn = true),
    User(userIdProvider.getUserId, RegisteredUser, loggedIn = true),
    User(userIdProvider.getUserId, RegisteredUser, loggedIn = false),
    User(userIdProvider.getUserId, Guest, loggedIn = true)
  ).map { user => user.id -> user }.toMap

  def getUsers: Iterable[User] = users.values.toSeq

  def getLoggedInUsers: Iterable[User] = getUsers.filter(_.loggedIn)

  def getUserById(userId: String): Either[NonExistentUserException, User] = users.get(userId) match {
    case Some(user) => Right(user)
    case None => Left(new NonExistentUserException(userId))
  }
}
