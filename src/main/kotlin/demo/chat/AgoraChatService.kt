package demo.chat

import io.agora.media.RtcTokenBuilder2
import org.springframework.stereotype.Service

@Service
class AgoraChatService(
    private val agoraProperties: AgoraProperties,
    private val creatorService: CreatorService
) {

    fun openChannel(channelName: String, userId: Long): String {
        creatorService.checkCreator()

        return RtcTokenBuilder2().buildTokenWithRtm(
            /* appId = */ agoraProperties.appId,
            /* appCertificate = */ agoraProperties.appCertificate,
            /* channelName = */ channelName,
            /* account = */ userId.toString(),
            /* role = */ RtcTokenBuilder2.Role.ROLE_PUBLISHER,
            /* tokenExpire = */ agoraProperties.tokenExpireSeconds,
            /* privilegeExpire = */ agoraProperties.tokenExpireSeconds
        )
    }

    fun joinChannel(channelName: String, userId: Long): String {
        creatorService.checkCreator()

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
}
