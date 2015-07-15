package com.rightster.techtalk.demo.service

import org.mockito.Mockito.{when => mockWhen}
import org.scalatest.mock.MockitoSugar
import org.scalatest.{FunSpec, GivenWhenThen, Matchers}

/**
 * Created by antonvanco on 15/07/2015.
 */
class MemoryUserServiceBddSpec extends FunSpec with GivenWhenThen with Matchers with MockitoSugar {

  describe("A MemoryUserService") {

    it("should generate and return users with provided user IDs") {
      Given("a random user ID generator")
      val userId1 = "USER-1"
      val userId2 = "USER-2"
      val userId3 = "USER-3"
      val userId4 = "USER-4"

      val mockUserIdProvider = mock[UserIdProvider]
      mockWhen(mockUserIdProvider.getUserId)
        .thenReturn(userId1)
        .thenReturn(userId2)
        .thenReturn(userId3)
        .thenReturn(userId4)

      And("an initialised MemoryUserService")
      val instance = new MemoryUserService(mockUserIdProvider)

      When("getUsers is invoked")
      val result = instance.getUsers

      Then("the result should have the correct size")
      result should have size 4

      And("the result should contain the expected entries")
      val expResult = Seq(
        User(userId1, Admin, loggedIn = true),
        User(userId2, RegisteredUser, loggedIn = true),
        User(userId3, RegisteredUser, loggedIn = false),
        User(userId4, Guest, loggedIn = true)
      )

      result should be (expResult)
    }
  }

}
