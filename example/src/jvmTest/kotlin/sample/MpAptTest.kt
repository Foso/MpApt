package sample

import de.jensklingenberg.mpapt.Generated
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test


class SampleTestsNative {

    val generated=Generated()

    @Test
    fun checkClassWasGenerated() {
    assertNotNull(generated)
    }


    @Test
    fun testHello() {



    }
}