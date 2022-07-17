val camelVersion: String by project

plugins {
    application
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

application {
    mainClass.set("ru.otus.financial.exchange.prototype.adapter.ApplicationKt")
}

repositories {
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation ("org.apache.camel:camel-core:$camelVersion")
    implementation ("org.apache.camel:camel-stream:$camelVersion")
    implementation ("org.apache.camel:camel-kafka:$camelVersion")
    implementation ("org.apache.camel:camel-netty:$camelVersion")
    implementation ("org.apache.camel:camel-main:$camelVersion")
    implementation ("org.apache.camel:camel-timer:$camelVersion")
    implementation ("org.apache.camel:camel-quartz:$camelVersion")
    implementation ("org.apache.camel:camel-jacksonxml:$camelVersion")
    implementation ("org.apache.camel:camel-jackson:$camelVersion")
    implementation ("org.apache.camel:camel-http:$camelVersion")
}