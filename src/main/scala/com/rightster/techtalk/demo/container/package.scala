package com.rightster.techtalk.demo

import com.rightster.techtalk.demo.service.{RandomUserIdProvider, MemoryUserService}
import com.typesafe.config.{ConfigFactory, Config}

/**
 * Created by antonvanco on 15/07/2015.
 */
package object container {

  val config = ConfigFactory.load()

  private val userIdPrefix = config.getString("techtalk.demo.userIdGenerator.prefix")

  object UserIdProviderInstance extends RandomUserIdProvider(userIdPrefix)

  object UserServiceInstance extends MemoryUserService(UserIdProviderInstance)

}
