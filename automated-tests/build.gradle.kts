import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    java
    `reminder-codegen`
    `reminder-test-format-checker`
}

group = "com.example"
version = "1.0"

repositories {
    jcenter()
}

dependencies {
    compile("org.testng:testng:6.14.3")
    compile("com.codeborne:selenide:5.2.4")
    compile("org.assertj:assertj-core:3.12.2")
    compile("io.rest-assured:rest-assured:4.0.0")
    compile("io.swagger:swagger-annotations:1.5.22")
    compile("io.gsonfire:gson-fire:1.8.3")
}

tasks.compileTestJava {
    finalizedBy("checkTestFormat")
}

tasks.test {
    dependsOn("cleanTest")
    useTestNG()

    testLogging {
        events("started", "passed", "failed", "skipped")
        showStandardStreams = true
        showStackTraces = true
        exceptionFormat = TestExceptionFormat.FULL
    }
}