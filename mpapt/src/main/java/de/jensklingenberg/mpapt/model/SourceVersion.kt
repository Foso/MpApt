package de.jensklingenberg.mpapt.model

enum class SourceVersion {

    KOTLIN_1_3, LATEST;

    companion object {
        fun latest(): SourceVersion {
            return LATEST
        }
    }

}