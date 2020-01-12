package com.sergenikov.crowsnest.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ExternalServiceExecutor {

  @Value("${extappexecutor.thread.core-pool}")
  private int corePoolSize;

  @Value("${extappexecutor.thread.max-pool}")
  private int maxPoolSize;

  @Value("${extappexecutor.queue.capacity}")
  private int queueCapacity;

  @Value("${extappexecutor.thread.timeout}")
  private int threadTimeout;

  @Bean
  @Qualifier("extAppExecutor")
  public ThreadPoolTaskExecutor threadPoolTaskExecutor() {

    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

    threadPoolTaskExecutor.setCorePoolSize(this.corePoolSize);
    threadPoolTaskExecutor.setMaxPoolSize(this.maxPoolSize);
    threadPoolTaskExecutor.setQueueCapacity(this.queueCapacity);
    threadPoolTaskExecutor.setKeepAliveSeconds(this.threadTimeout);

    return threadPoolTaskExecutor;
  }
}
