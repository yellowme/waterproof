package mx.yellowme.waterproof.common.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AlertDialog

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