package sample


import de.jensklingenberg.annotation.Extension


@Extension(to=[Hello::class])
class Person(
   @FunExt val name: String,
    val ssn: String




){
    @FunExt fun test(){

    }


}

annotation class FunExt


