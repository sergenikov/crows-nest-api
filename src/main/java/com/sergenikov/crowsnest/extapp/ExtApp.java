package com.sergenikov.crowsnest.extapp;

public interface ExtApp {

  /**
   * Plain and simple wrapper around execution of an external application. Does not define any
   * underlying behaviour of how the execution is done.
   *
   * @param extAppRequest - execution information
   * @return - {@link ExtAppResponse} with output of the execution.
   */
  ExtAppResponse run(ExtAppRequest extAppRequest);
}
