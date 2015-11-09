package org.opal;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class LolPlugin implements Plugin<Project> {
  @Override
  public void apply(Project project) {
    project.getExtensions().create("e", LolExtension.class);
  }
}

