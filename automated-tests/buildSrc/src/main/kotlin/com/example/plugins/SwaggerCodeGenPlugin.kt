package com.example.plugins

import io.swagger.codegen.DefaultGenerator
import io.swagger.codegen.config.CodegenConfigurator
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

const val SWAGGER_JSON_URL = "http://localhost:8080/v2/api-docs"
const val INVOKER_PACKAGE = "com.example.services.api.client"
const val API_PACKAGE = "com.example.services.api.controllers"
const val MODEL_PACKAGE = "com.example.entities.generated"

class SwaggerCodeGenPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("generateApi") { task ->
            task.doLast {
                // Clean up temp dir and existing API client packages
                File("${project.projectDir}/temp").deleteRecursively()
                deletePackageDirectories("${project.projectDir}",
                        listOf(INVOKER_PACKAGE, API_PACKAGE, MODEL_PACKAGE))

                // Configure and run code generation
                val config = CodegenConfigurator()
                config.inputSpec = SWAGGER_JSON_URL
                config.outputDir = "${project.projectDir}/temp"
                config.lang = "java"
                config.library = "rest-assured"
                config.additionalProperties = mapOf(
                        "invokerPackage" to INVOKER_PACKAGE,
                        "apiPackage" to API_PACKAGE,
                        "modelPackage" to MODEL_PACKAGE,
                        "dateLibrary" to "java8",
                        "hideGenerationTimestamp" to "true"
                )
                DefaultGenerator().opts(config.toClientOptInput()).generate()

                // Copy generated files to the corresponding directory in sources
                File("${project.projectDir}/temp/src/main/java")
                        .copyRecursively(File("${project.projectDir}/src/test/java"))

                // Clean up temp directory
                File("${project.projectDir}/temp").deleteRecursively()
            }
        }
    }

}

fun deletePackageDirectories(projectPath: String, packages: List<String>) {
    packages.forEach { pack ->
        File("$projectPath/src/test/java/${pack.replace(".", "/")}").deleteRecursively()
    }
}
