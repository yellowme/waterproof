package mx.yellowme.waterproof.common.extensions

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

@SuppressLint("MissingPermission")
        /**
 * Context related extensions, from checking connectivity to showing alerts
 *
 * Created by luisburgos on 9/15/17.
 */

fun Context.isOnline(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnectedOrConnecting
}

inline fun Context.alert(func: AlertDialog.Builder.() -> AlertDialog.Builder) {
    AlertDialog.Builder(this).func().show()
}

fun Context.showNetworkDialog() {
    alert {
        setTitle("Dispatch")
        setMessage("Mensaje dispatch")
        setPositiveButton("Ok") { dialog, _ ->
            dialog.dismiss()
        }
    }
}

fun Activity.makeKeyboardPanAdjusted(isPanAdjust: Boolean = true) {
    window.setSoftInputMode(
            if(isPanAdjust) {
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
            } else {
                WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED
            }
    )
}

fun Fragment.showKeyboardOn(editText: EditText) { activity?.showKeyboardOn(editText) }

fun Context.showKeyboardOn(editText: EditText) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
}