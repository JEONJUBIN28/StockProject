package org.seongsu.stockproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.seongsu.stockproject.Mapper")
public class StockProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockProjectApplication.class, args);
    }

}
