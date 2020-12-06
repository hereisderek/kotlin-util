package top.derekdev.kotlinutil.collection

import android.util.SparseArray
import kotlin.math.min

/**
 * @author: derek
 * @create: 6/12/20 9:33 pm
 **/


fun <T> SparseArray<out T>.joinToString(
    separator: CharSequence = ", ",
    prefix: CharSequence = "",
    postfix: CharSequence = "",
    limit: Int = -1,
    truncated: CharSequence = "...",
    transform: ((value: T, index: Int, key: Int) -> CharSequence)? = { value, index, key ->
        "$index:$key:$value"
    }
): String {
    val buffer = StringBuilder(prefix)
    val end = if (limit == -1) size() else min(limit, size())
    for (i in 0 until end) {
        if (i >= 1) buffer.append(separator)
        val key = keyAt(i)
        val element = valueAt(i)
        val output = transform?.invoke(element, i, key) ?: element.toString()
        buffer.append(output)
    }
    if (end < size()) buffer.append(truncated)
    buffer.append(postfix)
    return buffer.toString()
}