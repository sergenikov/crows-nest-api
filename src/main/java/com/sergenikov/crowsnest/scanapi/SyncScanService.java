package com.sergenikov.crowsnest.scanapi;

import com.sergenikov.crowsnest.nmap.NmapWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SyncScanService implements ScanService {

  private final NmapWrapper nmapWrapper;

  @Autowired
  public SyncScanService(final NmapWrapper nmapWrapper) {
    this.nmapWrapper = nmapWrapper;
  }

  @Override
  public ScanResponse scan(final ScanRequest scanRequest) {

    this.nmapWrapper.setHost(scanRequest.getIp());
    this.nmapWrapper.setArgs(new String[] {"-Pn", scanRequest.getIp()});

    return this.nmapWrapper.run();
  }
}
