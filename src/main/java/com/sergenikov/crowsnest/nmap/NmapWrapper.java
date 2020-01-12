package com.sergenikov.crowsnest.nmap;

import com.sergenikov.crowsnest.extapp.ExtApp;
import com.sergenikov.crowsnest.extapp.ExtAppRequest;
import com.sergenikov.crowsnest.extapp.ExtAppResponse;
import com.sergenikov.crowsnest.scanapi.ScanResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates interaction with nmap and how it's best to pass and format arguments for Nmap. It
 * also validates input into Nmap to ensure that arguments passed are in the right format and cannot
 * be abused.
 */
@Data
@Slf4j
@Component
public class NmapWrapper {

  private final ExtApp extApp;
  private final String name;
  private String[] args;
  private String host;

  @Autowired
  public NmapWrapper(@Qualifier("binaryWithArgsExtApp") ExtApp extApp) {
    this.extApp = extApp;
    this.name = "nmap";
  }

  public ScanResponse run() {

    final ExtAppResponse extAppResponse =
        this.extApp.run(
            ExtAppRequest.builder()
                .applicationCommand(this.getName())
                .args(this.args)
                .build());

    log.info("Ext app response {}", extAppResponse);

    return ScanResponse.builder().details(extAppResponse.getBody()).ip(this.getHost()).build();
  }

  public String[] basicScan(String host) {
    return new String[] {"-T5", "-Pn", "-p80,8080", host};
  }
}
