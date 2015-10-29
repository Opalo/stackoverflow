package lol

import spock.lang.Specification

class ASpec extends Specification {
  def 'spec'() {
    given:
      def a = new A()

    expect:
      a.validate([4, 6])
      !a.validate([4, 5])
  }
}
