plugins {
    java
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.openapi.generator") version "7.14.0"
}

group = "com.gfrag"
version = "0.0.1-SNAPSHOT"
description = "auth-service"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

openApiGenerate {
    generatorName.set("java")
    inputSpec.set("/home/alexey/marketplace-pet-project/infra/dtos.yaml")
    outputDir.set("/home/alexey/marketplace-pet-project/services/auth-service/src/main/java/com/gfrag/auth/dto/openapiGenerated")
    modelPackage.set("com.example.dto")
    generateModelTests.set(false)
    generateModelDocumentation.set(false)
    configOptions.set(mapOf(
        "dateLibrary" to "java21",
        "useBeanValidation" to "true"
    ))
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.16")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
    implementation("org.liquibase:liquibase-core")
    implementation("org.mapstruct:mapstruct:1.6.3")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
    runtimeOnly("com.h2database:h2")
}


tasks.withType<Test> {
    useJUnitPlatform()
}
