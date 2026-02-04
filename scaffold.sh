#!/bin/bash

mkdir -p app/src/main/java/com/sentinelai/app/{ai,billing,core,ui/dashboard,ui/theme}
mkdir -p app/src/main/res
mkdir -p app/src/main

cat > .gitignore << 'EOL'
*.iml
.gradle
/local.properties
/.idea
/build
/captures
.externalNativeBuild
EOL

cat > settings.gradle << 'EOL'
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "SentinelAI"
include(":app")
EOL

cat > build.gradle << 'EOL'
buildscript {
    ext.kotlin_version = "2.0.0"
}
EOL

cat > app/build.gradle << 'EOL'
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

android {
    namespace "com.sentinelai.app"
    compileSdk 36

    defaultConfig {
        applicationId "com.sentinelai.app"
        minSdk 26
        targetSdk 36
        versionCode 1
        versionName "1.0.0"
    }
}
EOL

echo "Scaffold complete"
