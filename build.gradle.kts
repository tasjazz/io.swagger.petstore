group = "io.swagger.petstore"
version = "0.1"

apply {
    plugin("java")
}

repositories {
    mavenCentral()
}


dependencies {
    compile("io.rest-assured", "rest-assured", "3.0.7")
    compile("junit", "junit", "4.12")
    compile("com.fasterxml.jackson.core", "jackson-databind", "2.9.4")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
