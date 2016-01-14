package com.sas.gradle.plugins.example

import org.gradle.api.Plugin
import org.gradle.api.Project

class ExamplePlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.logger.debug("ExamplePlugin: Running...")
    }
}
