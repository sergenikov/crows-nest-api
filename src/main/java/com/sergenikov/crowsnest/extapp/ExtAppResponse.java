package com.sergenikov.crowsnest.extapp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExtAppResponse {
  private String body;
}
