package top.derekdev.kotlinutil.collection

import kotlin.math.min

/**
 * @author: derek
 * @create: 5/12/20 11:29 am
 **/

/**
 *
 * This file contains mostly extension methods for collections, such as List, Array, Map and others
 *
 * */


/**
 * get the next item in the Iterator or null
 * */
fun <T> Iterator<T>.nextOrNull() : T? = if (hasNext()) next() else null


/**
 * get the size of given collection or default value (0 by default)
 * */
fun <T> Iterable<T>.collectionSizeOrDefault(default: Int = 0): Int = if (this is Collection<*>) this.size else default


/// merge

inline fun <K, V> Iterable<K>.mergeEmit(other: Iterable<V>, crossinline emitter: (a: K, b: V) -> Unit) {
    val thisIter = iterator()
    val thatIter = other.iterator()
    while (thisIter.hasNext() && thatIter.hasNext()) {
        emitter.invoke(thisIter.next(), thatIter.next())
    }
}

inline fun <K, V, R> Iterable<K>.mergeMap(other: Iterable<V>, into: MutableList<R>? = null, crossinline emitter: (a: K, b: V) -> R) : List<R> {
    val thisIter = iterator()
    val thatIter = other.iterator()
    var result : MutableList<R>? = into

    while (thisIter.hasNext() && thatIter.hasNext()) {
        if (result == null) result = ArrayList()
        result.add(emitter.invoke(thisIter.next(), thatIter.next()))
    }
    return result ?: emptyList()
}


///
fun <T> MutableList<T>.addIfNotContain(obj: T) : Boolean = if (!contains(obj)) add(obj) else false


