package com.rightster.techtalk.demo

import com.rightster.techtalk.demo.container._
import com.rightster.techtalk.demo.service.{MemoryUserService, UserService}
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by antonvanco on 15/07/2015.
 */
object Main {

  def main(args: Array[String]): Unit = {
    val userService1: UserService = UserServiceInstance

    userService1.getLoggedInUsers.foreach(println)

    val container = new ClassPathXmlApplicationContext("container-main.xml")
    val userService2 = container.getBean("userService", classOf[MemoryUserService])

    userService2.getLoggedInUsers.foreach(println)
  }

}
