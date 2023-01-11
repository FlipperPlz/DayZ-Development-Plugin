plugins {
    id("java")
    id("org.jetbrains.intellij") version "1.6.0"
    id("org.jetbrains.grammarkit") version "2021.2.2"
}

group = "com.flipperplz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("lib/BisUtils-1.0-SNAPSHOT.jar"))
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2021.3")
    type.set("IC") // Target IDE Platform
    plugins.set(listOf(/* Plugin Dependencies */))
}

sourceSets {
    main {
        java.srcDirs("src/main/java", "src/main/gen")
    }
}


tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "11"
        targetCompatibility = "11"
    }

    build {
        dependsOn.add(generateLexer)
        dependsOn.add(generateParser)
    }



    generateLexer {
        purgeOldFiles.set(true)
        source.set("src/main/java/com/flipperplz/dayzdev/language/rap/grammar/RapLexer.flex")
        targetDir.set("src/main/gen/com/flipperplz/dayzdev/language/rap/lexer/")
        targetClass.set("RapLexer.java")
    }

    generateParser {
        purgeOldFiles.set(true)
        source.set("src/main/java/com/flipperplz/dayzdev/language/rap/grammar/Rap.bnf")
        targetRoot.set("src/main/gen/")
        pathToParser.set("com/flipperplz/dayzdev/language/rap/parser/RapParser.java")
        pathToPsiRoot.set("com/flipperplz/dayzdev/language/rap/psi")
    }

    patchPluginXml {
        sinceBuild.set("213")
        untilBuild.set("223.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
