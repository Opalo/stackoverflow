package com.sas.gradle.plugins.example

import nebula.test.IntegrationSpec
import nebula.test.functional.ExecutionResult

class ExamplePluginIntegSpec extends IntegrationSpec {

    def 'setup and display the buildscript classpath'() {
        writeHelloWorld('example.hello')
        buildFile << '''
            apply plugin: 'java'
            apply plugin: com.sas.gradle.plugins.example.ExamplePlugin
            task show << {
                buildscript.configurations.classpath.each { println it }
            }
        '''.stripIndent()

        when:
        ExecutionResult result = runTasksSuccessfully('show')

        then:
        result.standardOutput.contains(':show')
    }
}
