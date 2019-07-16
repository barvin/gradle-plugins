package com.example.plugins

import io.swagger.codegen.DefaultGenerator
import io.swagger.codegen.config.CodegenConfigurator
import org.gradle.api.Plugin
import org.gradle.api.Project

class SwaggerCodeGenPlugin implements Plugin<Project> {
    private static final String SWAGGER_JSON_URL = 'http://localhost:8080/v2/api-docs'
    private static final String INVOKER_PACKAGE = 'com.example.services.api.client'
    private static final String API_PACKAGE = 'com.example.services.api.controllers'
    private static final String MODEL_PACKAGE = 'com.example.entities.generated'

    void apply(Project project) {
        project.task('generateApi', {
            doLast {
                new File("$project.projectDir/temp").deleteDir()
                deletePackageDirectories(project.projectDir.toString(), [INVOKER_PACKAGE, API_PACKAGE, MODEL_PACKAGE])

                def config = new CodegenConfigurator()
                config.inputSpec = SWAGGER_JSON_URL
                config.outputDir = "$project.projectDir/temp"
                config.lang = 'java'
                config.library = 'rest-assured'
                config.additionalProperties = [
                    "invokerPackage"         : INVOKER_PACKAGE,
                    "apiPackage"             : API_PACKAGE,
                    "modelPackage"           : MODEL_PACKAGE,
                    "dateLibrary"            : "java8",
                    "hideGenerationTimestamp": "true"
                ]
                new DefaultGenerator().opts(config.toClientOptInput()).generate()

                new AntBuilder().copy(todir: "$project.projectDir/src/test/java") {
                    fileset(dir: "$project.projectDir/temp/src/main/java")
                }
                new File("$project.projectDir/temp").deleteDir()
            }
        })
    }

    static void deletePackageDirectories(String projectPath, List<String> packages) {
        packages.forEach { pack ->
            new File("$projectPath/src/test/java/${pack.replace('.', '/')}").deleteDir()
        }
    }
}
