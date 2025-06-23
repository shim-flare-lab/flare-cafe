plugins {
  java
  id("org.springframework.boot") version "3.5.3"
  id("io.spring.dependency-management") version "1.1.7"
}

group = "com.flare.cafe"

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

dependencies {
  val querydslVersion = "5.1.0"

  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("com.querydsl:querydsl-jpa:$querydslVersion:jakarta")

  annotationProcessor("org.projectlombok:lombok")
  annotationProcessor("com.querydsl:querydsl-apt:$querydslVersion:jakarta")
  annotationProcessor("jakarta.persistence:jakarta.persistence-api")
  annotationProcessor("jakarta.annotation:jakarta.annotation-api")

  compileOnly("org.projectlombok:lombok")
  runtimeOnly("com.mysql:mysql-connector-j:9.0.0")

  developmentOnly("org.springframework.boot:spring-boot-docker-compose")

  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
  testImplementation("com.h2database:h2:2.2.220")
  testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<Test> {
  useJUnitPlatform()
}