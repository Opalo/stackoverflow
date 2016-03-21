package lol

import org.junit.Rule
import software.betamax.ProxyConfiguration
import software.betamax.TapeMode
import software.betamax.junit.Betamax
import software.betamax.junit.RecorderRule
import spock.lang.Specification

import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.core.MediaType

import groovy.json.JsonSlurper

class BetamaxSpec extends Specification {
    @Rule
    RecorderRule recorderRule = new RecorderRule(ProxyConfiguration.builder()
            .sslEnabled(true)
            .build())

    @Betamax(tape = 'jCenterKeywordQuery.tape', mode = TapeMode.WRITE_ONLY)
    def "Test basic keyword query with JCenter"() {
        given:
        def searcher = new Searcher()
        def result = searcher.searchJCenter('groovy*')
        expect:
        1 == 1
    }

    @Betamax(tape = 'mvnKeywordQuery.tape', mode = TapeMode.WRITE_ONLY)
    def "Test basic keyword query with Maven Central"() {
        given:
        def searcher = new Searcher()
        def result = searcher.searchMavenCentral('groovy')
        expect:
        1 == 1
    }

    class Searcher {
        def searchJCenter(qry) {
            new JsonSlurper().parseText ClientBuilder.newClient().
                    target('https://api.bintray.com/search/packages/maven/'.toURI()).
                    queryParam('q', qry).
                    request(MediaType.APPLICATION_JSON_TYPE).get(String)
        }

        def searchMavenCentral(qry) {
            new JsonSlurper().parseText ClientBuilder.newClient().
                    target('http://search.maven.org/solrsearch/select'.toURI()).
                    queryParam('q', qry).
                    queryParam('rows', 20).
                    queryParam('wt', 'json').
                    request().
                    get(String)
        }
    }
}
