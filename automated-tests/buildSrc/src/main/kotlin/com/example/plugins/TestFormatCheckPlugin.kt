package com.example.plugins

import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.AnnotationExpr
import com.github.javaparser.ast.expr.MemberValuePair
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr
import com.github.javaparser.utils.SourceRoot
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File

class TestFormatCheckPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("checkTestFormat") { task ->
            task.doLast {
                val errors = arrayListOf<String>()
                val packagePath = File("${project.projectDir}/src/test/java/com/example/tests").toPath()
                SourceRoot(packagePath)
                        .tryToParse("")
                        .filter { it.isSuccessful }
                        .map { it.result.get() }
                        .forEach { compilationUnit ->
                            compilationUnit.findAll(MethodDeclaration::class.java).forEach { method ->
                                if (method.isTest()) {
                                    errors.addAll(findErrorsWithTestCase(method))
                                    errors.addAll(findErrorsWithMandatoryTestProperties(method))
                                }
                            }
                        }
                if (errors.isEmpty()) {
                    println("Checking tests format passed")
                } else {
                    println("===================================================")
                    println("Errors in tests format:")
                    errors.forEach { println("> $it") }
                    println("===================================================")
                    throw RuntimeException("Checking tests format failed. See errors in log.")
                }
            }
        }
    }

    private fun MethodDeclaration.isTest(): Boolean =
            this.findFirst(AnnotationExpr::class.java) { it.nameAsString == "Test" }.isPresent

    /**
     * TestCase annotation should be present and match certain format
     */
    private fun findErrorsWithTestCase(method: MethodDeclaration): List<String> {
        val result = arrayListOf<String>()
        val testCase = method.findFirst(SingleMemberAnnotationExpr::class.java) { it.nameAsString == "TestCase" }
        if (testCase.isPresent) {
            val testCaseValue = testCase.get().memberValue.asStringLiteralExpr().value
            if (!testCaseValue.matches(Regex("REM-\\d+"))) {
                result.add("@TestCase annotation does not match format 'REM-1234' for test " +
                        "${method.nameAsString}. Actual value: '$testCaseValue'")
            }
        } else {
            result.add("No @TestCase annotation found for test ${method.nameAsString}")
        }
        return result
    }

    /**
     * Mandatory attributes are description, team and sprint
     */
    private fun findErrorsWithMandatoryTestProperties(method: MethodDeclaration): List<String> {
        val result = arrayListOf<String>()
        val test = method.findFirst(NormalAnnotationExpr::class.java) { it.nameAsString == "Test" }.get()
        if (!test.findFirst(MemberValuePair::class.java) { it.nameAsString == "description" }.isPresent) {
            result.add("Description not found in @Test for method ${method.nameAsString}")
        }
        val groups = test.findFirst(MemberValuePair::class.java) { it.nameAsString == "groups" }
        if (groups.isPresent) {
            if (!groups.get().value.toString().contains("Teams.")) {
                result.add("No Team found for test method ${method.nameAsString}")
            }
            if (!groups.get().value.toString().contains("Sprints.")) {
                result.add("No Sprint found for test method ${method.nameAsString}")
            }
        } else {
            result.add("Groups not found in @Test for method ${method.nameAsString}")
        }
        return result
    }
}
