package top.derekdev.kotlinutil.collection

/**
 * @author: derek
 * @create: 6/12/20 3:12 pm
 **/



/**
 * check if a collection contains any of the element in @param given [elements]
 */
inline fun <E> Collection<E>.anyOf(vararg elements: E): Boolean {
    return this.any { it in elements }
}

/**
 * check if a collection contains any of the element in @param given [elements]
 */
inline fun <E> Collection<E>.anyOf(elements: Collection<E>) : Boolean = any { it in elements }

