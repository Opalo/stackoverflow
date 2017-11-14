package lol

import spock.lang.Specification
import spock.lang.Unroll

class SessionSpec extends Specification {

    @Unroll
    "Basic session start on platform = #platform"() {
        when: "user stats a session on a platform"
        def response = Session.startSession(platform, id) // it does a REST request

        then: "response contains a userId"
        response.userId

        where:
        id | platform
        1  | "Facebook"
        2  | "Google"
        3  | "Apple"
    }

}
