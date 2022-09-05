package me.muan.map.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import javax.validation.constraints.NotBlank


@Configuration
@ConfigurationProperties(prefix = "google-map-credential")
class MapApiConf {
    @NotBlank
    var key: String= ""
}