import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
  java
  idea
  eclipse
    id("com.diffplug.spotless") version "5.16.0"
    id("com.github.ben-manes.versions") version "0.39.0"
}

repositories {
  mavenCentral()
}

dependencies {

	testImplementation("org.assertj:assertj-core:3.21.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}


val test by tasks.getting(Test::class) {
  useJUnitPlatform()
  testLogging {
    events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
  }
}