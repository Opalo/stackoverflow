package lol

import io.vavr.control.Option
import spock.lang.Specification

class LolSpec extends Specification {

    Lol l = new Lol();

    def 'should not throw any excpetion'() {
        when:
        l.validate(Option.of("lol"), { s -> !s.empty })

        then:
        noExceptionThrown()
    }

    def 'should throw NotFoundException'() {
        when:
        l.validate(Option.none(), null)

        then:
        thrown(NotFoundException)
    }

    def 'should throw ForbiddenException'() {
        when:
        l.validate(Option.of("lol"), { s -> s.empty });

        then:
        thrown(ForbiddenException)
    }

}
