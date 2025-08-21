package demo.chat

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "agora")
data class AgoraProperties(
    val appId: String,
    val appCertificate: String,
    val tokenExpireSeconds: Int,
    val customer: CustomerProperties
)

data class CustomerProperties(
    val key: String,
    val secret: String
)


