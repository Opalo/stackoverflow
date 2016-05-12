package lol

import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.LinkOption
import java.nio.file.Path
import java.nio.file.attribute.BasicFileAttributes

class WhyNotSpec extends Specification {

    def ''() {
        given:
        def whyNot = new WhyNot()

        and:
        Files.metaClass.static.readAttributes = { Path path, Class<BasicFileAttributes> cls, LinkOption... options ->
            null
        }

        and:
        def file = new File('lol-file')
        file.createNewFile()
        file.deleteOnExit()

        println(Files.readAttributes(file.toPath(), BasicFileAttributes))

        when:
        whyNot.fileCreationTime(file)

        then:
        def e = thrown(RuntimeException)
        e.message == 'bool'

    }
}
