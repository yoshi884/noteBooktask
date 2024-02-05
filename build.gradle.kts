plugins {
    id("java")
    id("io.spring.dependency-management") version "1.1.4"
    id ("org.springframework.boot") version "3.2.2"
   /* id ("io.freefair.lombok") version "8.4"*/
    kotlin("kapt") version "1.9.22"
}

group = "org.notebook"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")
 /*   implementation("org.mapstruct:mapstruct:1.5.5.Final")
    implementation("org.mapstruct:mapstruct-processor:1.4.2.Final")*/

    compileOnly ("org.projectlombok:lombok:1.18.24")
    annotationProcessor ("org.projectlombok:lombok:1.18.24")

    compileOnly ("org.mapstruct:mapstruct:1.5.1.Final")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.1.Final")
    implementation ("org.projectlombok:lombok-mapstruct-binding:0.2.0")



}

tasks.test {
    useJUnitPlatform()
}