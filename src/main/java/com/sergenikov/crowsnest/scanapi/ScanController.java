package com.sergenikov.crowsnest.scanapi;

import com.sergenikov.crowsnest.core.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@Slf4j
class ScanController {

  private final ScanService scanService;
  private final AsyncService asyncScanService;

  @Autowired
  ScanController(final ScanService scanService, final AsyncService asyncScanService) {
    this.scanService = scanService;
    this.asyncScanService = asyncScanService;
  }

  @CrossOrigin
  @PostMapping(
      path = "/scan",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ScanResponse scan(@RequestBody final ScanRequest scanRequest) {

    log.info("Processing request {}", scanRequest);

    return this.scanService.scan(scanRequest);
  }

  @CrossOrigin
  @PostMapping(
      path = "/asyncscan",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ScanResponse asyncScan(@RequestBody final ScanRequest scanRequest)
      throws ExecutionException, InterruptedException {

    log.info("Processing request {}", scanRequest);

    return this.asyncScanService.scan(scanRequest).get();
  }
}
