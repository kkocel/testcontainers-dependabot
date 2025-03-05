package com.example.testcontainersdependabot.testcontainersdependabot

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.localstack.LocalStackContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@SpringBootTest
@Testcontainers
class TestcontainersDependabotApplicationTests {
    companion object {
        @Container
        val localStack: LocalStackContainer =
            LocalStackContainer(DockerImageName.parse("localstack/localstack:" + readImageVersionFromDockerfile()))
                .withServices(LocalStackContainer.Service.S3)

        private fun readImageVersionFromDockerfile() =
            this::class
                .java
                .getResource("/Dockerfile")!!
                .readText()
                .lines()
                .first()
                .substringAfter(":")
    }

    @Test
    fun contextLoads() {
    }
}
