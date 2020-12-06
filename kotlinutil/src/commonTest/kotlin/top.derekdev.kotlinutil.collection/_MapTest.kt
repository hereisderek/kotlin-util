package top.derekdev.kotlinutil.collection

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class _MapTest {

    /// flatmap with byKey

    @Test
    fun `Map_flatMap_byKey`(){
        val originalText = "Derek"
        val key = originalText.toCharArray().map { it.toInt() }
        val start = 'A'.toInt()
        val end = 'z'.toInt()
        val map = HashMap<Int, Char>(end - start + 1)
        for (i in (start .. end)) {
            map[i] = i.toChar()
        }
        val actual = map.flatMap(key){ (key, value) ->
            listOf(value)
        }.toCharArray().concatToString()
        val expect = originalText.toCharArray().distinct().toCharArray().concatToString()
        assertTrue(actual.startsWith(expect))
    }


    @Test
    fun `Map_flatMap_byKey_2`(){
        val map = mapOf(2 to "122", 3 to "3455", 4 to "45567")
        val keyBy = listOf(3, 4)
        val result = map.flatMap(keyBy) { (key, value) ->
            value.take(key).toList()
        }.toList()
        val expected = "345455612".toList()

        assertEquals(expected, result)
    }

    /// flatmap with comparator
    @Test
    fun `Map_flatMap_comparator_1`() {
        val map = mapOf(2 to "23", 3 to "345", 5 to "56789")
        val comparator : Comparator<Map.Entry<Int, CharSequence>> = Comparator { a, b -> b.key - a.key }
        val result = map.flatMap(comparator) { (key, value) ->
            value.take(key - 1).toList()
        }
        val expected = "5678342".toList()
        assertEquals(expected, result)
    }

}