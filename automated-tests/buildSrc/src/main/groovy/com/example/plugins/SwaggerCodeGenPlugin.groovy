package com.example.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

class SwaggerCodeGenPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task('generateApi', {
            doLast {
                println('bbbbbbbbbbbbbbbbb')
            }
        })
    }
}
