package com.arturlogan.projetofinal.meme_final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.arturlogan.projetofinal.meme_final.feign")
public class MemeFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemeFinalApplication.class, args);
	}

}
