

_Map.kt
============


Map.flatMapTo
------------
Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original collection * and sorted so that the key presents in [byKey] is on the front, and the rest kept in the original order

e.g.


```kotlin
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
```

```kotlin
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
```

Collection
-----------

```kotlin
@Test
fun `Collection_any_element_of_vararg_Collection`() {
    assertTrue("abc".toList().anyOf('c', 'e', 'd'))
}
```

Iterable
-----------

mergeMap

```kotlin
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
```

