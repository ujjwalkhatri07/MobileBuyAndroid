package com.ujjwal.mobileShop

import com.ujjwal.mobileShop.entity.User
import com.ujjwal.mobileShop.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class MyTest {
    private lateinit var  userRepository:UserRepository
    @Test
    fun checkLogin() = runBlocking {

        userRepository = UserRepository()
        val response = userRepository.checkUser("email@gmail.com", "password")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun registerUser() = runBlocking {
        val user =
                User(user_username = "test", user_contactno = "test", user_email = "testuser@gmail.com", user_password = "testpassword")
        userRepository = UserRepository()
        val response = userRepository.registerUser(user)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
}