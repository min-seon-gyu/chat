package demo.chat

class CheckChannelViewRes(
    res: GetChannelInfoRes
) {
    val users: List<Long>? = res.data.users
    val total: Long = res.data.total
    val channelExist: Boolean = res.data.channelExist
}
