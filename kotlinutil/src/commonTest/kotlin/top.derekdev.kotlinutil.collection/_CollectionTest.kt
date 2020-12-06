package top.derekdev.kotlinutil.collection

/**
 * @author: derek
 * @create: 6/12/20 8:44 pm
 **/

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue


internal class _CollectionTest {


    @Test
    fun `Collection_any_element_of_vararg_Collection`() {
        assertTrue("abc".toList().anyOf('c', 'e', 'd'))
    }

    @Test
    fun `Collection_any_element_of_Collection_false`() {
        assertFalse("abf".toList().anyOf(listOf('c', 'e', 'd')))
    }


    @Test
    fun `Collection_any_element_of_Collection`() {
        assertTrue("abc".toList().anyOf(listOf('c', 'e', 'd')))
    }


}