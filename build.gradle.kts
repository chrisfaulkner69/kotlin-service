import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.spring") version "1.9.10" // Spring support
    kotlin("plugin.jpa") version "2.1.20" // Open classes for Spring Data JPA
    // For classes such as JPA, makes non-final (kotlin final by default)
    kotlin("plugin.allopen") version "2.1.10" // Open classes for Spring Data JPA
    kotlin("kapt") version "1.9.10"  // Kotlin Annotation Processor
}

group = "org.lucidant"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    testImplementation { exclude(group = "org.junit.vintage") }
}

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // OpenAPI with nice swagger UI
    implementation("org.springdoc:springdoc-openapi-ui:1.8.0")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("com.ninja-squad:springmockk:4.0.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        languageVersion = "1.9"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}