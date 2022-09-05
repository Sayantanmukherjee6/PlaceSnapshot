package me.muan.map.service

import me.muan.map.config.MapApiConf
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.URL

@Service
class MapService(
    private val mapApiConf: MapApiConf
) {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    @Throws(IOException::class)
    private fun getImageBytes(imageUrl: String): ByteArray? {
        val url = URL(imageUrl)
        val output = ByteArrayOutputStream()
        url.openStream().use { stream ->
            val buffer = ByteArray(4096)
            while (true) {
                val bytesRead: Int = stream.read(buffer)
                if (bytesRead < 0) {
                    break
                }
                output.write(buffer, 0, bytesRead)
            }
        }
        return output.toByteArray()
    }

    fun getMapByLocation(location: String): ResponseEntity<ByteArray> {
        val locationString= location.split(" ", ", ",". ").joinToString(separator = "+")
        logger.info("location to be queried: $location")
        val url = "https://maps.googleapis.com/maps/api/staticmap?center=" +
                "${locationString}&zoom=16&size=400x400&" +
                "key=${mapApiConf.key}"
        val output = getImageBytes(url)
        return ResponseEntity<ByteArray>(output, HttpStatus.OK)
    }
}