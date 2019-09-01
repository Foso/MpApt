package de.jensklingenberg.mpapt.common

import org.jetbrains.kotlin.descriptors.ModuleDescriptor

fun ModuleDescriptor.simpleName() = this.name.asString().replace("<", "").replace(">", "")
