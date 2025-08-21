package demo.chat

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/agora")
class AgoraApi(
    private val agoraTokenService: AgoraChatService
) {

    @PostMapping("/open")
    fun open(): OpenChannelViewRes {
        val userId = 1L

        return OpenChannelViewRes(agoraTokenService.openChannel(userId))
    }

    @PostMapping("/{channelName}/join")
    fun join(@PathVariable channelName: String): JoinChannelViewRes {
        val userId = 2L

        return JoinChannelViewRes(agoraTokenService.joinChannel(channelName, userId))
    }

    @GetMapping("/check")
    fun check(@RequestParam channelName: String, @RequestParam appId: String): CheckChannelViewRes {
        return CheckChannelViewRes(agoraTokenService.checkChannel(appId, channelName))
    }
}
