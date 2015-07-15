package com.rightster.techtalk.demo.service

import java.util.UUID

import org.mockito.Mockito.{times, verify, when}
import org.scalatest.mock.MockitoSugar
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by antonvanco on 15/07/2015.
 */
class MemoryUserServiceSpec extends FlatSpec with Matchers with MockitoSugar {

  "MemoryUserService" should "generate and return users with provided user IDs" in {
    val userId1 = "USER-1"
    val userId2 = "USER-2"
    val userId3 = "USER-3"
    val userId4 = "USER-4"

    val mockUserIdProvider = mock[UserIdProvider]
    when(mockUserIdProvider.getUserId)
      .thenReturn(userId1)
      .thenReturn(userId2)
      .thenReturn(userId3)
      .thenReturn(userId4)

    val expResult = Seq(
      User(userId1, Admin, loggedIn = true),
      User(userId2, RegisteredUser, loggedIn = true),
      User(userId3, RegisteredUser, loggedIn = false),
      User(userId4, Guest, loggedIn = true)
    )

    val instance = new MemoryUserService(mockUserIdProvider)

    val result = instance.getUsers

    result should be (expResult)

    verify(mockUserIdProvider, times(4)).getUserId
  }

  it should "return logged in users" in {
    val mockUserIdProvider = mock[UserIdProvider]
    when(mockUserIdProvider.getUserId)
      .thenReturn(UUID.randomUUID.toString)
      .thenReturn(UUID.randomUUID.toString)
      .thenReturn(UUID.randomUUID.toString)
      .thenReturn(UUID.randomUUID.toString)

    val instance = new MemoryUserService(mockUserIdProvider)
    val result = instance.getLoggedInUsers

    result should have size 3

    result.foreach { user =>
      user should be ('loggedIn)
    }
  }

}
