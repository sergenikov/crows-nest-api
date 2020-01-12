package com.sergenikov.crowsnest.scanapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

// @Profile({"default", "production"})
@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ScanController {

  private final ScanService scanService;

  @Autowired
  ScanController(final ScanService scanService) {
    this.scanService = scanService;
  }

  @CrossOrigin
  @PostMapping(
      path = "/scan",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ScanResponse scan(@RequestBody final ScanRequest scanRequest) {

    log.info("Processing request {}", scanRequest);

    return this.scanService.scan(scanRequest);
  }
}
