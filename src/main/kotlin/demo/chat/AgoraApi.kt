package demo.chat

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/agora")
class AgoraApi(
    private val agoraTokenService: AgoraTokenService
) {

    @GetMapping("/generate-token")
    fun generateToken(@RequestBody request: AgoraGenerateTokenRequest): String {
        return agoraTokenService.generateRtcRtmToken(request.channelName, request.userId)
    }
}
