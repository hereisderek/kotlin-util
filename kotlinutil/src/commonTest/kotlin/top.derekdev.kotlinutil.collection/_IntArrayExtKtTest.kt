package top.derekdev.kotlinutil.collection

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * @author: derek
 * @create: 5/12/20 12:05 pm
 */

internal class _IntArrayExtKtTest {

    @BeforeTest
    fun setUp() {
    }



    @Test
    fun `toIntString_IntArray`() {
        val intArray = intArrayOf(1, 2, 3)
        val expectedString = "[1,2,3]"
        assertEquals(expectedString, intArray.toIntString())
    }


    @Test
    fun `toIntString_IterableInt`() {
        val intArray = listOf(1, 2, 3)
        val expectedString = "[1,2,3]"
        assertEquals(expectedString, intArray.toIntString())
    }



    @Test
    fun `toIntString_IterableIntArray`() {
        val intArray = intArrayOf(1, 2, 3)
        val iterableIntArray = listOf(intArray, intArray, intArray)
        val expectedString = "[[1,2,3],[1,2,3],[1,2,3]]"
        assertEquals(expectedString, iterableIntArray.toIntString())
    }


    @Test
    fun `toIntString_IntArray2D`() {
        val intArray = intArrayOf(1, 2, 3)
        val iterableIntArray : IntArray2D = arrayOf(intArray, intArray, intArray)
        val expectedString = "[[1,2,3],[1,2,3],[1,2,3]]"
        assertEquals(expectedString, iterableIntArray.toIntString())
    }



}