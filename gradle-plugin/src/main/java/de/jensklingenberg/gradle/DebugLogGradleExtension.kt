package de.jensklingenberg.gradle

open class DebugLogGradleExtension {
  /** If [false], this plugin won't actually be applied */
  var enabled: Boolean = true

  /** FQ names of supportedModules that should count as debuglog supportedModules */
  var supportedModules: List<String> = emptyList()
}
