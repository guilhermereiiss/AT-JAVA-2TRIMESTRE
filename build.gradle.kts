plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin-bundle:6.6.0")
    implementation("org.slf4j:slf4j-simple:2.0.9")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("io.javalin:javalin-testtools:6.6.0")
}

tasks.test {
    useJUnitPlatform()
}