package top.derekdev.kotlinutil.collection

/**
 * @author: derek
 * @create: 8/12/20 10:13 pm
 **/

interface MutablePair<A, B> {
    var first: A
    var second: B
    val snapshot: Pair<A, B>

    fun clearSnapshot()
    fun use(usage: ((first: A, second: B) -> Unit)) = usage.invoke(first, second)
    fun useSelf(usage: (MutablePair<A, B>.(first: A, second: B) -> Unit)) = usage.invoke(this, first, second)
    fun set(first: A, second: B){
        this.first = first
        this.second = second
    }
}

fun <A, B> mutablePairOf(first: A, second: B) : MutablePair<A, B> = MutablePairImpl(first, second)


open class MutablePairImpl<A, B> (first: A, second: B) : MutablePair<A, B> {
    private var _snapshot: Pair<A, B>? = null

    override var first: A = first; set(value) {
        field = value
        clearSnapshot()
    }
    override var second: B = second; set(value) {
        field = value
        clearSnapshot()
    }

    override val snapshot: Pair<A, B> get() = getSnapShot()

    private fun getSnapShot() : Pair<A, B> =  (_snapshot /*as? Pair<A, B>?*/) ?: Pair(first, second)

    override fun clearSnapshot() {
        _snapshot = null
    }
}



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

