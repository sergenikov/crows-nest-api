package com.sergenikov.crowsnest.extapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BinaryWithArgsExtAppTest {

  private ExtApp scanProvider;

  @Before
  public void setup() {
    this.scanProvider = new BinaryWithArgsExtApp();
  }

  @Test
  public void performScan_should_return_validResponseBody_when_scanRunDidNotFail() {

    final ExtAppRequest extAppRequest =
        ExtAppRequest.builder()
            .applicationCommand("nmap")
            .args(new String[] {"192.168.0.1"})
            .build();

    final ExtAppResponse actualExtAppResponse = this.scanProvider.run(extAppRequest);

    assertThat(actualExtAppResponse).isNotNull();
    assertThat(actualExtAppResponse.getBody()).isNotNull().isNotBlank();
  }

  @Test(expected = ExtAppException.class)
  public void performScan_should_throwException_when_issueRunningApplication() {

    final ExtAppRequest extAppRequest =
        ExtAppRequest.builder()
            .applicationCommand("notnmap")
            .args(new String[] {"192.168.0.1"})
            .build();
    this.scanProvider.run(extAppRequest);

    fail("Should've thrown exception");
  }
}
