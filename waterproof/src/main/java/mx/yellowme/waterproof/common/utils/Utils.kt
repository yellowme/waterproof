package mx.yellowme.waterproof.common.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.view.WindowManager
import android.widget.EditText


/**
 * Created by luisburgos on 9/14/17.
 */
class Utils {
    companion object {
        fun dpToPx(dp: Int): Int {
            return (dp * Resources.getSystem().displayMetrics.density).toInt()
        }

        fun getScreenHeight(context: Context): Float {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val size = Point()
            display.getSize(size)
            return size.y.toFloat()
        }

        fun getScreenWidth(context: Context): Float {
            val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = wm.defaultDisplay
            val size = Point()
            display.getSize(size)
            return size.x.toFloat()
        }
    }
}

fun makeInteractive(canInteract: Boolean = true, vararg editTexts: EditText?){
    for(current in editTexts) {
        current?.isEnabled = canInteract
    }
}