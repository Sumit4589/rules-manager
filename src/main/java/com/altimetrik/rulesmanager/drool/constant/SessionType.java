package com.altimetrik.rulesmanager.drool.constant;

public enum SessionType {

  STATELESS("stateless"), STATEFUL("stateful");

  private String value;

  SessionType(String value) {
    this.value = value;
  }
}
