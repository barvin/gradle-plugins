package com.example.plugins.format_checker

import com.github.javaparser.ParseResult
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.AnnotationExpr
import com.github.javaparser.ast.expr.MemberValuePair
import com.github.javaparser.utils.SourceRoot
import org.gradle.api.Plugin
import org.gradle.api.Project

class TestFormatCheckPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.task('checkTestFormat', {
            doLast {
                def errors = []

                // Parse all source files
                def sourceRoot = new SourceRoot(new File("$project.projectDir/src/test/java/com/example/tests").toPath());
                List<ParseResult> parseResults = sourceRoot.tryToParse("");

                // Now get all compilation unitsList
                List<CompilationUnit> allCompilationUnits = parseResults
                    .find { it.isSuccessful() }
                    .collect { it.getResult().get() }
                allCompilationUnits.forEach { compilationUnit ->
                    compilationUnit.findAll(MethodDeclaration.class).forEach { method ->
                        if (method.findFirst(AnnotationExpr.class, { it.nameAsString == 'Test' }).isPresent()) {

                            if (method.findFirst(AnnotationExpr.class, { it.nameAsString == 'TestCase' }).isPresent()) {

                            } else {
                                errors.add("No @TestCase annotation found for test $method.nameAsString")
                            }

                            method.findAll(AnnotationExpr.class).forEach { annotation ->
                                println(annotation.nameAsString)
                                if (annotation.isNormalAnnotationExpr()) {
                                    annotation.findAll(MemberValuePair.class).forEach {
                                        println("$it.name --> $it.value")
                                    }
                                } else if (annotation.isSingleMemberAnnotationExpr()) {
                                    println(annotation.asSingleMemberAnnotationExpr().memberValue.asStringLiteralExpr().value)
                                }
                            }
                        }
                    }
                }
            }
        })
    }

    static List<Node> getNodes(List<CompilationUnit> cus, Class nodeClass) {
        List<Node> res = new LinkedList();
        cus.forEach { res.addAll(it.findAll(nodeClass)) }
        return res;
    }
}
