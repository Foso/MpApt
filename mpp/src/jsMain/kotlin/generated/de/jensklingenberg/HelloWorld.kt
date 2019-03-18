// //Generated
package de.jensklingenberg

import kotlin.String

class Greeter(val name: String) {
    fun greet() {
        println("""Hello, $name""")
    }
}

fun main(vararg args: String) {
    Greeter(args[0]).greet()
}
