package top.derekdev.kotlinutil.collection

/**
 * @author: derek
 * @create: 8/12/20 10:13 pm
 **/

interface MutablePair<A, B> {
    var first: A
    var second: B
    val snapshot: Pair<A, B> get() = Pair(first, second)

    fun use(usage: ((first: A, second: B) -> Unit)) = usage.invoke(first, second)
    fun useSelf(usage: (MutablePair<A, B>.(first: A, second: B) -> Unit)) = usage.invoke(this, first, second)
    fun set(first: A, second: B){
        this.first = first
        this.second = second
    }
}

fun <A, B> mutablePairOf(first: A, second: B) : MutablePair<A, B> = MutablePairImpl(first, second)


data class MutablePairImpl<A, B> (override var first: A, override var second: B) : MutablePair<A, B>//, Serializable



/*
class MutablePairSafe<A, B> constructor (
    first: A,
    second: B
) : MutablePairImpl<A, B>(first, second) {

    override var first: A
        get() = synchronized(this){ super.first }
        set(value) = synchronized(this) {
            super.first = value
        }

    override var second: B
        get() = synchronized(this){ super.second }
        set(value) = synchronized(this) {
            super.second = value
        }

    override val snapshot: Pair<A, B> get() = synchronized(this) { super.snapshot }

    override fun clearSnapshot() = synchronized(this) {
        super.clearSnapshot()
    }
}
*/

