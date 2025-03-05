package com.example.testcontainersdependabot.testcontainersdependabot

import org.springframework.boot.fromApplication
import org.springframework.boot.with
import org.testcontainers.utility.TestcontainersConfiguration

fun main(args: Array<String>) {
    fromApplication<TestcontainersDependabotApplication>().with(TestcontainersConfiguration::class).run(*args)
}
