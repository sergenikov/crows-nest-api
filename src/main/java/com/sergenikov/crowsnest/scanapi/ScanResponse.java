package com.sergenikov.crowsnest.scanapi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScanResponse {

  private String ip;

  private String details;
}
