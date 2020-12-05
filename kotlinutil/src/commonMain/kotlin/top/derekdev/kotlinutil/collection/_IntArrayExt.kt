package top.derekdev.kotlinutil.collection

import kotlin.jvm.JvmName

/**
 * @author: derek
 * @create: 5/12/20 11:41 am
 **/

typealias IntArray2D = Array<IntArray>
typealias ListOfIntArray = List<IntArray>



/// conversions from array to string

/**
 * convert into a string that represents the content of the array
 * e.g. [1,2,3]
 */
@JvmName("toIntString_IntArray")
fun IntArray.toIntString(
    separator: CharSequence = ",", prefix: CharSequence = "[", postfix: CharSequence = "]", limit: Int = -1, truncated: CharSequence = "...", transform: ((Int) -> CharSequence)? = null
) = joinToString(separator, prefix, postfix, limit, truncated, transform)

/**
 * convert into a string that represents the content of the array
 * e.g. [1,2,3]
 */

@JvmName("toIntString_IterableInt")
fun Iterable<Int>.toIntString(
    separator: CharSequence = ",", prefix: CharSequence = "[", postfix: CharSequence = "]", limit: Int = -1, truncated: CharSequence = "...", transform: ((Int) -> CharSequence)? = null
) = joinToString(separator, prefix, postfix, limit, truncated, transform)

/**
 * * convert into a string that represents the content of the array
 * e.g. [[5,9],[9,0],[0,0],[7,0],[4,3]]
 * */
@JvmName("toIntString_IterableIntArray")
fun Iterable<IntArray>.toIntString(
    separator: CharSequence = ",", prefix: CharSequence = "[", postfix: CharSequence = "]", limit: Int = -1, truncated: CharSequence = "...", innerTransform: ((Int) -> CharSequence)? = null
) = joinToString(separator, prefix, postfix, limit, truncated){ it.toIntString(separator, prefix, postfix, limit, truncated, innerTransform) }

/**
 * * convert into a string that represents the content of the array
 * e.g. [[5,9],[9,0],[0,0],[7,0],[4,3]]
 * */
@JvmName("toIntString_IntArray2D")
fun IntArray2D.toIntString(
    separator: CharSequence = ",", prefix: CharSequence = "[", postfix: CharSequence = "]", limit: Int = -1, truncated: CharSequence = "...", innerTransform: ((Int) -> CharSequence)? = null
) = joinToString(separator, prefix, postfix, limit, truncated){ it.toIntString(separator, prefix, postfix, limit, truncated, innerTransform) }

