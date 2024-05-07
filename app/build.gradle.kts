plugins {
    java
    application
    war
    checkstyle
    jacoco
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("jakarta.servlet.jsp:jakarta.servlet.jsp-api:3.1.1")
    
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation("org.junit.platform:junit-platform-launcher:1.10.1")
    testImplementation("org.easymock:easymock:4.3")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

jacoco {
    toolVersion = "0.8.11"
    reportsDirectory = layout.buildDirectory.dir("app/build/reports/jacoco")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    maxHeapSize = "1G"
    testLogging {
        events("skipped", "passed", "failed")
    }
    finalizedBy("jacocoTestReport")
}

tasks.named<Check>("checkstyle") {
    configFile = file("../config/checkstyle/sun_checks.xml")
    ignoreFailures = true
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required = true
        html.required = true
        xml.outputLocation = file("build/reports/jacoco/jacocoReport.xml")
        html.outputLocation = file("build/reports/jacoco/jacocoReport.html")
    }
}

tasks.named("check") {
    dependsOn("jacocoTestReport")
}
