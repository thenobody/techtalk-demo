package com.rightster.techtalk.demo.service

/**
 * Created by antonvanco on 15/07/2015.
 */
class RedisUserService extends UserService {
  def getUsers: Iterable[User] = ???

  def getUserById(userId: String): Either[NonExistentUserException, User] = ???

  def getLoggedInUsers: Iterable[User] = ???
}
