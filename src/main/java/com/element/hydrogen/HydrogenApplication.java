package com.element.hydrogen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author yanyu
 */
@SuppressWarnings("unused")
@SpringBootApplication
@MapperScan(value = "com.element.hydrogen.mapper")//开启注解扫描，指定扫描文件为dao包底下的所有包含`@mapper`的类。
public class HydrogenApplication {

	public static void main(String[] args) {
		SpringApplication.run(HydrogenApplication.class, args);
	}

}
















