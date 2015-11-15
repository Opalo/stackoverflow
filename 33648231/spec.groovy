@Grab(group='org.spockframework', module='spock-core', version='1.0-groovy-2.4')

import spock.lang.*

class H2JSpec extends Specification {

    
    def "let's build the mappings for template"() {
        setup:
        def task = new A()

        when:
        def f = File.createTempFile('aaa', 'bbb')
        f.write(a)

        then:
        task.prepareCommandList(f).size() == b

        where:
        a            || b
        """#dsfs

    """ || 3
        """#this file defines the mapping of h files declarations into java errorcodes: autoenum=off prefix=ec_ class=test.framework.base.MsgErrorCodes
    """ || 2

    }
}

class A {
   def prepareCommandList(f) {
       f.readLines()
   }
}