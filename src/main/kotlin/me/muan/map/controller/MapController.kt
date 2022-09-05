package me.muan.map.controller

import me.muan.map.service.MapService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable


@RestController
@RequestMapping("/api/v1/map", produces = ["application/json"])
class MapController(
    private val mapService: MapService
) {
    @GetMapping(value = ["/address/{location}"], produces = [MediaType.IMAGE_JPEG_VALUE])
    fun getMapByLocation(
        @PathVariable location: String
    ): ResponseEntity<ByteArray> {
        return mapService.getMapByLocation(location)
    }
}