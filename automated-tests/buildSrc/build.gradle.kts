plugins {
    kotlin("jvm") version "1.3.50"
    `java-gradle-plugin`
}

gradlePlugin {
    plugins {
        create("codegen") {
            id = "reminder-codegen"
            implementationClass = "com.example.plugins.SwaggerCodeGenPlugin"
        }
        create("testFormatCheck") {
            id = "reminder-test-format-checker"
            implementationClass = "com.example.plugins.TestFormatCheckPlugin"
        }
    }
}

repositories {
    jcenter()
}

dependencies {
    compile("io.swagger:swagger-codegen:2.4.7")
    compile("com.github.javaparser:javaparser-core:3.14.7")
}