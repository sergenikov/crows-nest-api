package com.sergenikov.crowsnest.extapp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value = "binaryWithArgsExtApp")
public class BinaryWithArgsExtApp implements ExtApp {

  @Override
  public ExtAppResponse run(final ExtAppRequest extAppRequest) {

    final CommandLine commandLine = CommandLine.parse(extAppRequest.getApplicationCommand());

    Arrays.stream(extAppRequest.getArgs()).forEach(commandLine::addArgument);

    log.info("Command line{}", commandLine);

    final Executor executor = new DefaultExecutor();

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    executor.setStreamHandler(new PumpStreamHandler(byteArrayOutputStream));

    try {
      int exitCode = executor.execute(commandLine);

      log.trace(
          "External application {} exited with code {}",
          extAppRequest.getApplicationCommand(),
          exitCode);

    } catch (IOException e) {
      throw new ExtAppException("Issue running application. Request = " + extAppRequest, e);
    }

    return ExtAppResponse.builder().body(byteArrayOutputStream.toString()).build();
  }
}
