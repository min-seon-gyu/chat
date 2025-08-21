package demo.chat

import io.agora.media.RtcTokenBuilder2
import org.springframework.stereotype.Service
import java.util.*

@Service
class AgoraChatService(
    private val agoraProperties: AgoraProperties,
    private val agoraClient: AgoraClient
) {

    fun openChannel(userId: Long): AgoraData {
        val channelName = createChannelName()

        val token = RtcTokenBuilder2().buildTokenWithRtm(
            /* appId = */ agoraProperties.appId,
            /* appCertificate = */ agoraProperties.appCertificate,
            /* channelName = */ channelName,
            /* account = */ userId.toString(),
            /* role = */ RtcTokenBuilder2.Role.ROLE_PUBLISHER,
            /* tokenExpire = */ agoraProperties.tokenExpireSeconds,
            /* privilegeExpire = */ agoraProperties.tokenExpireSeconds
        )

        return AgoraData(token = token, channelName = channelName)
    }

    fun joinChannel(channelName: String, userId: Long): String {
        return RtcTokenBuilder2().buildTokenWithRtm(
            /* appId = */ agoraProperties.appId,
            /* appCertificate = */ agoraProperties.appCertificate,
            /* channelName = */ channelName,
            /* account = */ userId.toString(),
            /* role = */ RtcTokenBuilder2.Role.ROLE_SUBSCRIBER,
            /* tokenExpire = */ agoraProperties.tokenExpireSeconds,
            /* privilegeExpire = */ agoraProperties.tokenExpireSeconds
        )
    }

    fun checkChannel(appId: String, channelName: String): GetChannelInfoRes {
        val plainCredentials = agoraProperties.customer.key + ":" + agoraProperties.customer.secret
        val base64Credentials = Base64.getEncoder().encodeToString(plainCredentials.toByteArray())

        val authorizationHeader = "Basic $base64Credentials"

        return agoraClient.getChannelInfo(authorizationHeader, appId, channelName)
    }

    private fun createChannelName(): String {
        return UUID.randomUUID().toString()
    }
}

data class AgoraData(
    val token: String,
    val channelName: String
)
