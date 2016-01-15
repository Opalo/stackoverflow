package lol;

import groovy.lang.GroovyShell;

public class Lol {

  public static void main(String[] args) {
    String processingCode = "def hello_world() { println 'Hello, world!' }; hello_world();";
    GroovyShell shell = new GroovyShell();
    shell.evaluate(processingCode);
  }
}
