package demo.chat

import feign.Feign
import feign.Logger
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients
class OpenFeignConfig {

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.FULL
    }

    @Bean
    fun feignClient(): Feign.Builder {
        val okHttpClient = OkHttpClient.Builder()
            .cookieJar(CookieJar.NO_COOKIES)
            .build()

        return Feign.builder()
            .client(feign.okhttp.OkHttpClient(okHttpClient))
    }
}
