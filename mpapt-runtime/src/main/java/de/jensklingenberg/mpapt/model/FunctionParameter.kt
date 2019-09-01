package de.jensklingenberg.mpapt.model

data class FunctionParameter(val parameterName: String, val packagee: Package)

data class Package(val classname: String, val packagename: String)