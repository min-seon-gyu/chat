package demo.chat

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.apache.tomcat.util.http.parser.Authorization
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "agoraClient", url = "https://api.agora.io")
interface AgoraClient {

    @GetMapping("/dev/v1/channel/user/{appId}/{channelName}")
    fun getChannelInfo(
        @RequestHeader("Authorization") authorization: String,
        @PathVariable("appId") appId: String,
        @PathVariable("channelName") channelName: String
    ): GetChannelInfoRes

}

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetChannelInfoRes(
    val data: GetChannelInfoData

)

@JsonIgnoreProperties(ignoreUnknown = true)
data class GetChannelInfoData(
    val users: List<Long>?,
    val total: Long,
    @JsonProperty("channel_exist")
    val channelExist: Boolean
)
