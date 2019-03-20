package sample


import de.jensklingenberg.annotation.Extension


@Extension(to = [CommonHello::class])
class CommonPerson(
        @FunExt val name: String,
        val ssn: String


) {
    @FunExt
    fun commonHallo() {

    }


    fun commonCiao() {

    }


}



