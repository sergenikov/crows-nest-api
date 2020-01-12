package com.sergenikov.crowsnest.nmap;

import lombok.Data;

import java.util.HashMap;

@Data
public class GenericAppWrapper {

  protected String name;
  protected HashMap<String, String> args;

  protected GenericAppWrapper(String name, HashMap<String, String> args) {
    this.name = name;
    this.args = args;
  }

  //  public ScanResponse run();
}
