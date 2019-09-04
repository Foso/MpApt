package de.jensklingenberg.mpapt

import de.jensklingenberg.testAnnotations.Redacted


class Person(val name: String, @Redacted val ssn: String,@Redacted val ssn2: String)

fun main() {
    val person = Person("John Doe", "123-456-7890","3333")

    println(person) // --> Person(name=John Doe, ssn="HELLO", ssn2="HELLO")

}