package com.rightster.techtalk.demo.service

import java.util.UUID

/**
 * Created by antonvanco on 15/07/2015.
 */
trait UserIdProvider {
  def getUserId: String
}

class RandomUserIdProvider(prefix: String) extends UserIdProvider {
  def getUserId: String = prefix + UUID.randomUUID.toString
}
