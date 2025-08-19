package demo.chat

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/agora")
class AgoraApi(
    private val agoraTokenService: AgoraChatService
) {

    @PostMapping("/{channelName}/open")
    fun openChannel(@PathVariable channelName: String): AgoraTokenViewRes {
        val userId = 1L

        return AgoraTokenViewRes(agoraTokenService.openChannel(channelName, userId))
    }

    @PostMapping("/{channelName}/join")
    fun joinChannel(@PathVariable channelName: String): AgoraTokenViewRes {
        val userId = 2L

        return AgoraTokenViewRes(agoraTokenService.joinChannel(channelName, userId))
    }
}
