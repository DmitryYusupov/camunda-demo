import Build_gradle.Version.CAMUNDA
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.1"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
	kotlin("plugin.jpa") version "1.4.21"
}

group = "ru.yusdm.training"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_15

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "2020.0.0"

enum class Version(val version: String) {
	CAMUNDA("7.14.0")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	//implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-webapp:${CAMUNDA.version}")
	//implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter-rest:${CAMUNDA.version}")
	implementation("org.camunda.bpm.springboot:camunda-bpm-spring-boot-starter:${CAMUNDA.version}")
	//implementation("org.camunda.bpm:camunda-engine-plugin-connect:${CAMUNDA.version}")
	//implementation("org.camunda.bpm:camunda-connect-core:${CAMUNDA.version}")
	implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "15"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}