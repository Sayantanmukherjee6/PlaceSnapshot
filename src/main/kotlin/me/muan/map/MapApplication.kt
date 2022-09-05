package me.muan.map

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["me.muan.map"])
class MapApplication

fun main(args: Array<String>) {
	SpringApplication.run(MapApplication::class.java, *args)
}
