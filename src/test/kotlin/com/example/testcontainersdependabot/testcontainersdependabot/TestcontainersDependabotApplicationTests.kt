package com.example.testcontainersdependabot.testcontainersdependabot

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@Testcontainers
class TestcontainersDependabotApplicationTests {
    @Test
    fun contextLoads() {
        val imageVersion = readImageVersionFromDockerfile()
    }

    private fun readImageVersionFromDockerfile() =
        this
            .javaClass
            .getResource("/Dockerfile")!!
            .readText()
            .lines()
            .first()
            .substringAfter(":")
}
