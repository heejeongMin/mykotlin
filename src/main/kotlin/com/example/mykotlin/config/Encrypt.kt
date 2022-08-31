package com.example.mykotlin.config

import org.springframework.context.annotation.Configuration
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Configuration
class EncryptConfig(applicationProperties: ApplicationProperties) {
    val secretKey : String = applicationProperties.encryption.secretKey
    val iv : String = applicationProperties.encryption.iv

    init {
        cipher.init(
            Cipher.ENCRYPT_MODE,
            SecretKeySpec(secretKey.toByteArray(), "AES"),
            IvParameterSpec(iv.toByteArray())
        )

        decryptCipher.init(
            Cipher.DECRYPT_MODE,
            SecretKeySpec(secretKey.toByteArray(), "AES"),
            IvParameterSpec(iv.toByteArray())
        )
    }

    companion object {
        val cipher : Cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING")
        val decryptCipher : Cipher =  Cipher.getInstance("AES/CBC/PKCS5PADDING")
    }
}

fun String.encrypt() =
    String(Base64.getEncoder().encode(EncryptConfig.cipher.doFinal(this.toByteArray())))

fun String.decrypt() = String(Base64.getDecoder().decode(this.toByteArray()))
fun String.decryptt() =
    String(EncryptConfig.decryptCipher.doFinal(Base64.getDecoder().decode(this.toByteArray())))


