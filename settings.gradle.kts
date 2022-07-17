rootProject.name = "financial-exchange-prototype"

pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        val kotestVersion: String by settings
        val openApiVersion: String by settings

        kotlin("jvm") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        id("io.kotest.multiplatform") version kotestVersion
        id("org.openapi.generator") version openApiVersion
    }
}

include("financial-exchange-prototype-adapter")
include("financial-exchange-prototype-transport-main-openapi")
include("financial-exchange-prototype-common")
include("financial-exchange-prototype-mapper")
