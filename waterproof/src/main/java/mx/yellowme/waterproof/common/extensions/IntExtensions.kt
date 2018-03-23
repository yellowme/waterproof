package mx.yellowme.waterproof.common.extensions

import android.content.res.Resources

/**
 * Created by luisburgos on 9/25/17.
 */
val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()