package com.sergenikov.crowsnest.scanapi;

import com.sergenikov.crowsnest.core.AsyncService;
import com.sergenikov.crowsnest.nmap.NmapWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.concurrent.CompletableFuture;

@Component(value = "asyncScanService")
public class AsyncScanService implements AsyncService {

  private final NmapWrapper nmapWrapper;

  @Autowired
  public AsyncScanService(final NmapWrapper nmapWrapper) {
    this.nmapWrapper = nmapWrapper;
  }

  @Async("extAppExecutor")
  public CompletableFuture<ScanResponse> scan(@RequestBody final ScanRequest scanRequest) {

    this.nmapWrapper.setHost(scanRequest.getIp());
    this.nmapWrapper.setArgs(new String[] {"-Pn", scanRequest.getIp()});

    ScanResponse scanResponse = this.nmapWrapper.run();

    return CompletableFuture.completedFuture(scanResponse);
  }
}
