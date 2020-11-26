package top.derekdev

import org.junit.Assert.assertTrue
import org.junit.Test
import top.derekdev.kotlinutil.Greeting

class AndroidGreetingTest {

    @Test
    fun testExample() {
        assertTrue("Check Android is mentioned", Greeting().greeting().contains("Android"))
    }
}