package lol;

import java.util.List;

public class A {

  boolean validate(List<Integer> list) {
    return list.stream().parallel().filter(this::shouldValidate).allMatch(this::isValid);
  }

  boolean shouldValidate(int i) {
    return i > 3;
  }

  boolean isValid(int i) {
    return i % 2 == 0;
  }
}