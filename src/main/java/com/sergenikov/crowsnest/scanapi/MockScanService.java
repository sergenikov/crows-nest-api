package com.sergenikov.crowsnest.scanapi;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
public class MockScanService implements ScanService {

  @Override
  public ScanResponse scan(ScanRequest scanRequest) {
    return ScanResponse.builder()
        .ip(scanRequest.getIp())
        .details(
            ""
                + "Starting Nmap 7.80 ( https://nmap.org ) at 2019-12-22 21:24 PST\n"
                + "Nmap scan report for 192.168.0.1\n"
                + "Host is up (0.0032s latency).\n"
                + "Not shown: 996 closed ports\n"
                + "PORT     STATE    SERVICE\n"
                + "22/tcp   filtered ssh\n"
                + "23/tcp   filtered telnet\n"
                + "80/tcp   open     http\n"
                + "8080/tcp open     http-proxy\n"
                + "MAC Address: 1C:1B:68:97:09:CD (Arris Group)\n"
                + "\n"
                + "Nmap done: 1 IP address (1 host up) scanned in 1.53 seconds")
        .build();
  }
}
