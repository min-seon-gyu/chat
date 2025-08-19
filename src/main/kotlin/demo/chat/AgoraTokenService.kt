package demo.chat

import io.agora.media.RtcTokenBuilder2
import org.springframework.stereotype.Service

@Service
class AgoraTokenService(
    private val agoraProperties: AgoraProperties
) {

    /**
     * 주어진 채널 이름과 사용자 ID로 Agora RTM 토큰을 생성합니다.
     *
     * @param channelName 토큰을 생성할 채널 이름
     * @param userId 토큰을 생성할 사용자 ID
     * @value tokenExpire RTM 권한
     * @value privilegeExpire RTC 권한
     * @return 생성된 RTM 토큰 문자열
     */
    fun generateRtcRtmToken(channelName: String, userId: Long): String {
        val role = RtcTokenBuilder2.Role.ROLE_PUBLISHER

        return RtcTokenBuilder2().buildTokenWithRtm(
            /* appId = */ agoraProperties.appId,
            /* appCertificate = */ agoraProperties.appCertificate,
            /* channelName = */ channelName,
            /* account = */ userId.toString(),
            /* role = */ role,
            /* tokenExpire = */ agoraProperties.tokenExpireSeconds,
            /* privilegeExpire = */ agoraProperties.tokenExpireSeconds
        )
    }
}
