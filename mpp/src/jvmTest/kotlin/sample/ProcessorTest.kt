package sample

import generated.Project
import org.junit.Assert
import org.junit.Test


class ProcessorTest{

    @Test
    fun hello(){

        val project = Project()
        Assert.assertEquals("Hallo",project.name)
    }

}