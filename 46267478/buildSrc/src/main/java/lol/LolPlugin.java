package lol;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.owasp.dependencycheck.gradle.DependencyCheckPlugin;
import org.owasp.dependencycheck.gradle.extension.DependencyCheckExtension;

public class LolPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        final DependencyCheckPlugin dcp = project.getPlugins().apply(DependencyCheckPlugin.class);
        project.getLogger().lifecycle("LOL {}", dcp);

        final DependencyCheckExtension dce = (DependencyCheckExtension) project.getExtensions().findByName("dependencyCheck");
        project.getLogger().lifecycle("LOL {}", dce);
        project.getLogger().lifecycle("LOL {}", dce.getAutoUpdate());
        dce.setAutoUpdate(true);
        project.getLogger().lifecycle("LOL {}", dce.getAutoUpdate());

    }

}
