package lol

import com.google.common.collect.Collections2
import org.gradle.api.Plugin
import org.gradle.api.Project

class LolPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task("lolTask") {
            doLast {
                println Collections2.transform([1, 2, 3], { it * 2 })
            }
        }
    }
}
