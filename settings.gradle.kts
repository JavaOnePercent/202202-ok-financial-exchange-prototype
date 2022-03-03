rootProject.name = "financial-exchange-prototype"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings

        kotlin("jvm") version kotlinVersion apply false
    }
}

include("financial-exchange-prototype-app")
