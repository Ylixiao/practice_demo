package com.sys.tryxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;



@SpringBootApplication
@EnableCaching
@MapperScan("com.sys.tryxx.domain")
public class TryxxApplication {
	public static void main(String[] args) {
		SpringApplication.run(TryxxApplication.class, args);
	}
}
