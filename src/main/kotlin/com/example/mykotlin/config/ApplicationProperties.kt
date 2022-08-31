package com.example.mykotlin.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "application")
class ApplicationProperties (
    val encryption : Encryption = Encryption(secretKey = "", iv = "")
)

data class Encryption (
    val secretKey : String,
    val iv : String
)