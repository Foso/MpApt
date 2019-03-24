package de.jensklingenberg.gradle

open class DebugLogGradleExtension {
  /** If [false], this plugin won't actually be applied */
  var enabled: Boolean = true

  /** FQ names of annotations that should count as debuglog annotations */
  var annotations: List<String> = emptyList()
}
