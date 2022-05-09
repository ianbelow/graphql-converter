import org.gradle.kotlin.dsl.DependencyHandlerScope

object LibDependencies {

    object Gson {
        private const val gson = "com.google.code.gson:gson:${Versions.gson}"

        fun DependencyHandlerScope.gson() {
            "implementation"(gson)
        }
    }

    object Retrofit {
        private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

        fun DependencyHandlerScope.retrofit() {
            "implementation"(retrofit)
        }
    }
}

object PluginDependencies {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val ktGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Plugins {
    const val Library = "com.android.library"
    const val KotlinAndroid = "kotlin-android"
    const val MavenPublish = "maven-publish"
}
