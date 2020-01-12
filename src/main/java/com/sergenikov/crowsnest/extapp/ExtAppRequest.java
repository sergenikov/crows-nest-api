package com.sergenikov.crowsnest.extapp;

import lombok.Builder;
import lombok.Data;

/**
 * Encapsulates command and arguments of the application to execute. May include other supporting
 * information about the application.
 */
@Data
@Builder
public class ExtAppRequest {

  private String applicationCommand;
  private String[] args;
}
