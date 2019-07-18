package com.example.plugins

import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.AnnotationExpr
import com.github.javaparser.ast.expr.MemberValuePair
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr
import com.github.javaparser.utils.SourceRoot
import org.gradle.api.Plugin
import org.gradle.api.Project

import java.nio.file.Path

class TestFormatCheckPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.task('checkTestFormat', {
            doLast {
                def errors = []
                Path packagePath = new File("$project.projectDir/src/test/java/com/example/tests").toPath()
                new SourceRoot(packagePath)
                    .tryToParse("")
                    .find { it.isSuccessful() }
                    .collect { it.getResult().get() }
                    .forEach { compilationUnit ->
                        compilationUnit.findAll(MethodDeclaration.class).forEach { method ->
                            if (isTest(method)) {
                                errors.addAll(findErrorsWithTestCase(method))
                                errors.addAll(findErrorsWithMandatoryTestProperties(method))
                            }
                        }
                    }
                if (errors.empty) {
                    println("Checking tests format passed")
                } else {
                    println('===================================================')
                    println('Errors in tests format:')
                    errors.each { println("> ${it}") }
                    println('===================================================')
                    throw new RuntimeException("Checking tests format failed. See errors in log.")
                }
            }
        })
    }

    private static List<String> findErrorsWithMandatoryTestProperties(MethodDeclaration method) {
        def result = []
        def test = method.findFirst(NormalAnnotationExpr.class, { it.nameAsString == 'Test' }).get()
        if (!test.findFirst(MemberValuePair.class, { it.nameAsString == 'description' }).isPresent()) {
            result << "Description not found in @Test for method $method.nameAsString"
        }
        def groups = test.findFirst(MemberValuePair.class, { it.nameAsString == 'groups' })
        if (groups.isPresent()) {
            if (!groups.get().value.toString().contains('Teams.')) {
                result << "No Team found for test method $method.nameAsString"
            }
            if (!groups.get().value.toString().contains('Sprints.')) {
                result << "No Sprint found for test method $method.nameAsString"
            }
        } else {
            result << "Groups not found in @Test for method $method.nameAsString"
        }
        return result
    }

    private static List<String> findErrorsWithTestCase(MethodDeclaration method) {
        def result = []
        def testCase = method.findFirst(SingleMemberAnnotationExpr.class, { it.nameAsString == 'TestCase' })
        if (testCase.isPresent()) {
            def testCaseValue = testCase.get().memberValue.asStringLiteralExpr().value
            if (!testCaseValue.matches(~/REM-\d+/)) {
                result << "@TestCase annotation does not match format 'REM-1234' for test $method.nameAsString. " +
                    "Actual value: '$testCaseValue'"
            }
        } else {
            result << "No @TestCase annotation found for test $method.nameAsString"
        }
        return result
    }

    private static boolean isTest(MethodDeclaration method) {
        method.findFirst(AnnotationExpr.class, { it.nameAsString == 'Test' }).isPresent()
    }

}
