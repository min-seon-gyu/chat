package demo.chat

class OpenChannelViewRes(
    data: AgoraData
) {
    val token: String = data.token
    val channelName: String = data.channelName
}
