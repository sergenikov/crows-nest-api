package com.sergenikov.crowsnest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CrowsNestApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(CrowsNestApiApplication.class, args);
  }
}
