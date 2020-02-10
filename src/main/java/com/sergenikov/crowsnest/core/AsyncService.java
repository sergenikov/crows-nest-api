package com.sergenikov.crowsnest.core;

import com.sergenikov.crowsnest.scanapi.ScanRequest;
import com.sergenikov.crowsnest.scanapi.ScanResponse;
import java.util.concurrent.CompletableFuture;

public interface AsyncService {

  CompletableFuture<ScanResponse> scan(ScanRequest scanRequest);
}
