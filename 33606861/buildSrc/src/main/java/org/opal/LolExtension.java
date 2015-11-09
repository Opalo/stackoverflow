package org.opal;

import groovy.lang.Closure;

import static groovy.lang.Closure.DELEGATE_FIRST;

public class LolExtension {
  String property1;
  private Property2 property2 = new Property2();

  public void property2(Closure c) {
    c.setResolveStrategy(DELEGATE_FIRST);
    c.setDelegate(property2);
    c.call();
  }

  public String getProperty1() {
    return property1;
  }

  public void setProperty1(String property1) {
    this.property1 = property1;
  }

  public void setProperty2(Property2 property2) {
    this.property2 = property2;
  }

  public Property2 getProperty2() {
    return property2;
  }
}