package com.sergenikov.crowsnest.nmap;

import com.sergenikov.crowsnest.scanapi.ScanResponse;

public interface AppWrapper<A extends GenericAppWrapper> {

  ScanResponse run();
}
