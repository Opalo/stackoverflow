package lol

import spock.lang.Specification
import utils.EnumBuster

class SampleServiceTest extends Specification {

    def 'no exception thrown for all enums'() {
        given:
        def service = new SampleService()

        when:
        service.handleFoo(se)

        then:
        noExceptionThrown()

        where:
        se << SampleEnum.values()
    }

    def 'exception thrown when bad enum passed'() {
        given:
        def buster = new EnumBuster<SampleEnum>(SampleEnum.class, SampleService.class)
        def service = new SampleService()

        service.handleFoo(SampleEnum.ONE)
        service.handleFoo(SampleEnum.TWO)

        def THREE = buster.make('THREE',2)
        buster.addByValue(THREE)
        System.out.println(Arrays.toString(SampleEnum.values()));

        when:
        service.handleFoo(THREE)

        then:
        def e = thrown(IllegalArgumentException)
        e.message == 'pl'
    }
}
