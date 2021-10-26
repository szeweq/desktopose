import org.jetbrains.compose.compose

buildscript {
    val composeVer = "1.0.0-beta1"

    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    dependencies {
        classpath("org.jetbrains.compose:compose-gradle-plugin:$composeVer")
        classpath(kotlin("gradle-plugin", version = "1.5.31"))
    }
}

plugins {
    `java-library`
    `maven-publish`
}

allprojects {
    repositories {
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
        google()
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

subprojects {
    apply {
        plugin("java-library")
        plugin("kotlin")
        plugin("org.jetbrains.compose")
        plugin("maven-publish")
    }

    java {
        withSourcesJar()
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["java"])
            }
        }
    }

    dependencies {
        implementation(compose.desktop.common)
    }
}
