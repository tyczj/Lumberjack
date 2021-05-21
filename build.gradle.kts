plugins {
    kotlin("multiplatform") version "1.4.32"
    id("com.android.library")
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
    id("maven-publish")
    id("signing")
}

group = "io.github.tyczj.lumberjack"
version = "1.0.0"

ext["signing.keyId"] = ""
ext["signing.password"] = ""
ext["signing.secretKeyRingFile"] = ""

repositories {
    google()
    mavenCentral()
    maven {
        setUrl("https://plugins.gradle.org/m2/")
    }
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

kotlin {
    android{
        publishLibraryVariants("release")
    }
    iosX64("ios") {
        binaries {
            framework {
                baseName = "lumberjack"
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val androidMain by getting
        val androidTest by getting
        val iosMain by getting
        val iosTest by getting
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
    }
}

afterEvaluate {
    publishing {
        repositories {
            maven {
                name = "sonatype"
                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials {
                    username = rootProject.ext["ossrhUsername"]?.toString()
                    password = rootProject.ext["ossrhPassword"]?.toString()
                }
            }
        }

        publications.withType<MavenPublication> {

            artifact(javadocJar.get())

            pom{
                name.set("Lumberjack")
                description.set("Tweedle is an Android library built around the Twitter v2 API built fully in Kotlin using Kotlin Coroutines")
                url.set("https://github.com/tyczj/Lumberjack")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("tyczj")
                        name.set("Jeff Tycz")
                        email.set("tyczj359@gmail.com")
                    }
                }
                scm {
                    url.set("https://github.com/tyczj/Lumberjack")
                }
            }
        }
    }
}

ext["signing.keyId"] = rootProject.ext["signing.keyId"]?.toString()
ext["signing.password"] = rootProject.ext["signing.password"]?.toString()
ext["signing.secretKeyRingFile"] = rootProject.ext["signing.secretKeyRingFile"]?.toString()

signing {
    sign(publishing.publications)
}

apply(from = "${rootDir}/scripts/publish-root.gradle")