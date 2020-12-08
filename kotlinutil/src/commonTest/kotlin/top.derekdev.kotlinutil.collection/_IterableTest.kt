package top.derekdev.kotlinutil.collection

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue
import top.derekdev.kotlinutil.collection.*
import kotlin.test.assertEquals

/**
 * @author: derek
 * @create: 5/12/20 12:05 pm
 */

internal class _IterableTest {

    @BeforeTest
    fun setUp() {
    }



    @Test
    fun `Iterator_nextOrNull`() {
        val intArray = intArrayOf(1, 2, 3)
        val iterator = intArray.iterator()
        for(i in 0 until intArray.size + 2) {
            val result = iterator.nextOrNull()
            assertEquals(intArray.getOrNull(i), result)
        }
    }


    @Test
    fun `Iterable_collectionSizeOrDefault`() {
        val intArray = arrayListOf<Int>(0, 1, 2)
        assertEquals(intArray.size, intArray.collectionSizeOrDefault(-1))
        val intRange : IntRange = (0 until 10)
        assertEquals(-1, intRange.collectionSizeOrDefault(-1))
    }

    /// merge
    @Test
    fun `Iterable_mergeEmit`() {
        val i1 = 1 until 10
        val i2 = 'a' until 'd'
        val result1 = ArrayList<String>()
        val result2 = ArrayList<String>()
        i1.mergeEmit(i2){ a, b ->
            result1.add("$a$b")
        }
        i2.mergeEmit(i1){ b, a ->
            result2.add("$a$b")
        }
        val expected = listOf("1a", "2b", "3c")
        assertEquals(expected, result1, )
        assertEquals(expected, result2)
    }


    @Test
    fun `Iterable_mergeMap`() {
        val i1 = 1 until 10
        val i2 = 'a' until 'd'
        val result1 = ArrayList<String>()
        val result2 = i1.mergeMap(i2, result1) { a, b -> "$a$b" }
        val result3 = i2.mergeMap(i1) { b, a -> "$a$b" }

        val expected = listOf("1a", "2b", "3c")
        assertEquals(expected, result1)
        assertEquals(expected, result2)
        assertEquals(expected, result3)
    }


    @Test
    fun `Iterable_mergeMap_empty`() {
        val i1 = emptyList<Int>()
        val i2 = 'a' until 'd'
        val result1 = ArrayList<String>()
        val result2 = i1.mergeMap(i2, result1) { a, b -> "$a$b" }
        val result3 = i2.mergeMap(i1) { b, a -> "$a$b" }

        assertTrue(result1.isEmpty())
        assertTrue(result2.isEmpty())
        assertTrue(result3.isEmpty())
    }


    @Test
    fun `MutableList_addIfNotContain`() {
        val list = mutableListOf("a", "b", "c")
        assertEquals(list.size, 3)
        list.addIfNotContain("d")
        assertEquals(list.size, 4)
        assertEquals(list, listOf("a", "b", "c", "d"))
        list.addIfNotContain("a")
        assertEquals(list.size, 4)
        assertEquals(list, listOf("a", "b", "c", "d"))
    }


}