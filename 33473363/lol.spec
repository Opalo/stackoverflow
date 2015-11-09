@Grab('org.spockframework:spock-core:1.0-groovy-2.4')
@Grab('cglib:cglib:3.1') 
@Grab('org.ow2.asm:asm-all:5.0.3') 

import spock.lang.Shared
import spock.lang.Specification

class Test extends Specification {

    LinkService linkService = Mock(LinkService)

    @Shared
    Closure openInNewWindow = { it.isOpenInNewWindw()}

    @Shared
    def httpsLink = { Link l -> l.url.startsWith("https") }

    @Shared
    def secureLink = new Link(
        url: "https://exmaple.com",
        openInNewWindw: false
    )

    @Shared
    def externalLink = new Link(
        url: "http://exmaple.com",
        openInNewWindw: true
    )

    def "failing closure test"() {
        when:
        def secureLinkResult = linkService.doStuff(secureLink)
        def externalLinkResult = linkService.doStuff(externalLink)

        then:
        secureLinkResult == 1
        externalLinkResult == 2

        1 * linkService.doStuff(httpsLink) >> 1
        1 * linkService.doStuff(openInNewWindow) >> 2
    }

    def "passing closure test"() {
        when:
        def secureLinkResult = linkService.doStuff(secureLink)
        def externalLinkResult = linkService.doStuff(externalLink)

        then:
        secureLinkResult == 1
        externalLinkResult == 2

        1 * linkService.doStuff({Link l -> l.url.startsWith("https")}) >> 1
        1 * linkService.doStuff({Link l -> l.openInNewWindw}) >> 2
    }
}
    
class Link {
    String url
    boolean openInNewWindw
}

interface LinkService {
    int doStuff(Link link)
}

//Hey @pniederw! Is it possible in #spockframework to reuse closures for mock verification: http://stackoverflow.com/questions/33473363/spock-reusable-closure-in-mocks?
