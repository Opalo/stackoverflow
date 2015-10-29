@Grab('org.spockframework:spock-core:0.7-groovy-2.0')
@Grab('cglib:cglib:3.1') 
@Grab('org.ow2.asm:asm-all:5.0.3') 

import spock.lang.*

class MyTestSpec extends Specification {
  def 'spec'() {
    given:
       def a = new A()

    expect:
       a.validate([4, 6])
       !a.validate([4, 5])
    }
}

class A {
    boolean validate(List<Integer> list) {
        list.stream().parallel().filter({ it -> shouldValidate(it) }).allMatch({it -> isValid(it)})
    }
    
    boolean shouldValidate(int i) {
        i > 3
    }
    
    boolean isValid(int i) {
        i % 2 == 0
    }
}



