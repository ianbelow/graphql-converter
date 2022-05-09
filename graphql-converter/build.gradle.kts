import LibDependencies.Gson.gson
import LibDependencies.Retrofit.retrofit

plugins {
    id(Plugins.Library)
    id(Plugins.KotlinAndroid)
    id(Plugins.MavenPublish)
}

android {
    compileSdk = Versions.targetSdkVersion

    defaultConfig {
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    kotlinOptions {
        jvmTarget = Versions.kotlinTarget
    }
}

dependencies {
    gson()
    retrofit()
}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class.java) {
                from(components["release"])
                groupId = "com.ianbelov"
                artifactId = "graphqlconverter"
                version = "0.0.1"
            }
        }
    }
}