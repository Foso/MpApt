package de.jensklingenberg.compiler.kaptmpp

enum class SourceVersion {

    KOTLIN_1_3;

    companion object {
        fun latest(): SourceVersion {
            return KOTLIN_1_3
        }
    }

}