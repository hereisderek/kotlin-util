package top.derekdev.kotlinutil.collection


import top.derekdev.kotlinutil.collection.*
import kotlin.test.*

/*
 *
 * @author: derek
 * @create: 8/12/20 10:44 pm
 **/

class MutablePairTest {

    @Test
    fun `mutablePairOf`() {
        val pair : MutablePair<Int, String> = mutablePairOf(1, "a")
        val snapShot1 = pair.snapshot
        assertEquals(1, snapShot1.first)
        assertEquals("a", snapShot1.second)

        pair.use { first, second ->
            assertEquals(1, first)
            assertEquals("a", second)
        }
        pair.apply {
            assertEquals(1, first)
            assertEquals("a", second)
            first = 2
            assertEquals(2, first)
            assertEquals("a", second)
            second = "b"
            assertEquals(2, first)
            assertEquals("b", second)
        }
        pair.useSelf { first, second ->
            assertEquals(2, first)
            assertEquals("b", second)
            this.first = 3
            assertEquals(2, first)
            assertEquals(3, this.first)
            assertEquals("b", second)
        }

        assertEquals(1, snapShot1.first)
        assertEquals("a", snapShot1.second)
        val snapShot2 = pair.snapshot

        assertNotEquals(pair, snapShot2)
        assertNotEquals(snapShot1, snapShot2)
        assertEquals(3, snapShot2.first)
        assertEquals("b", snapShot2.second)
    }

    @Test
    fun `mutablePairOfNull`() {
        val pair = mutablePairOf<Int?, String?>(null, null)
        pair.use { first, second ->
            assertEquals(first, null)
            assertEquals(second, null)
        }
        pair.set(1, null)
        pair.use { a, b ->
            assertEquals(1, a)
            assertEquals(null, b)
        }
        val snapshot1 = pair.snapshot
        snapshot1.apply {
            assertEquals(1, first)
            assertEquals(null, second)
        }
        pair.first = null
        val snapshot2 = pair.snapshot
        assertNotEquals(snapshot1, snapshot2)
    }


}