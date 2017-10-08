package mx.yellowme.waterproof.common.extensions

/**
 * Declare an extension function that calls a lambda called block if the value is null
 *
 * Created by luisburgos on 9/15/17.
 */
inline fun <T> T.guard(block: T.() -> Unit): T {
    if (this == null) block(); return this
}