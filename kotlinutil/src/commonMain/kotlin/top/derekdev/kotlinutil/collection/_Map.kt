package top.derekdev.kotlinutil.collection

/**
 * @author: derek
 * @create: 6/12/20 3:12 pm
 **/


/// flatmap with byKey


/**
 * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original collection
 * and sorted so that the key presents in [byKey] is on the front, and the rest kept in the original order
 * @param
 *
 */
inline fun <K, V, R, C : MutableCollection<in R>> Map<out K, V>.flatMapTo(
    destination: C,
    byKey: Iterable<out K>? = null,
    transform: (Map.Entry<K, V>) -> Iterable<R>
): C {
    this.flatMap(transform)
    val uniqueKey = byKey?.distinct() ?: emptyList()
    val entries = this.entries

    for(key in uniqueKey) {
        val entriesForKey = entries.filter { it.key == key }
        entriesForKey.forEach {
            val obj = transform(it)
            destination.addAll(obj)
        }
    }
    entries.forEach {
        if (!uniqueKey.contains(it.key)) {
            val obj = transform(it)
            destination.addAll(obj)
        }
    }
    return destination
}



inline fun <K, V, R> Map<out K, V>.flatMap(
    byKey: Iterable<out K>? = null,
    transform: (Map.Entry<K, V>) -> Iterable<R>
) : List<R> = flatMapTo(ArrayList<R>(), byKey, transform)



/// flatmap with comparator
/**
 * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original collection
 * and sorted in an order that defined by [comparator]
 * @param
 */
inline fun <K, V, R, C : MutableCollection<in R>> Map<out K, V>.flatMapTo(
    destination: C,
    comparator: Comparator<in Map.Entry<K, V>>,
    crossinline transform: (Map.Entry<K, V>) -> Iterable<R>
): C {
    this.entries.sortedWith(comparator).forEach {
        val obj = transform(it)
        destination.addAll(obj)
    }
    return destination
}


/**
 * @see flatMapTo
 * */
inline fun <K, V, R> Map<out K, V>.flatMap(
    comparator: Comparator<in Map.Entry<K, V>>,
    crossinline transform: (Map.Entry<K, V>) -> Iterable<R>
): Iterable<R> = flatMapTo(ArrayList<R>(), comparator, transform)





