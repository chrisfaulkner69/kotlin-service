import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.23"
    // For classes such as JPA, makes non-final (kotlin final by default)
    kotlin("plugin.allopen") version "1.9.23"

    // Enables Java annotation processors
    kotlin("kapt") version "1.9.23"
}

group = "org.lucidant"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_19

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
    implementation("io.springfox:springfox-swagger2:3.0.0")
    runtimeOnly("org.springdoc:springdoc-openapi-ui:1.7.0")
    runtimeOnly("io.springfox:springfox-swagger-ui:3.0.0")


    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("com.ninja-squad:springmockk:4.0.2")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "19"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

