package top.derekdev.kotlinutil.collection

/**
 * @author: derek
 * @create: 5/12/20 11:29 am
 **/

/**
 *
 * This file contains mostly extension methods for collections, such as List, Array, Map and others
 *
 * */


fun <T> Iterator<T>.nextOrNull() : T? = if (hasNext()) next() else null
