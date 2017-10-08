package mx.yellowme.waterproof.common.extensions

import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.TextView

/**
 * Set of extensions for View and ViewGroup related classes
 *
 * Created by luisburgos on 9/14/17.
 */
fun View.makeVisible(visible: Boolean = true) {
    visibility = if(visible) View.VISIBLE else View.GONE
}

fun View.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

fun View.isNotVisible(): Boolean {
    return visibility == View.GONE
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun ViewGroup.inflate(layoutIdRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutIdRes, this, false)
}

//MARK: - Color
fun TextView.textWhite() {
    textColor(android.R.color.white)
}

fun TextView.textBlack() {
    textColor(android.R.color.black)
}

fun TextView.textColor(id: Int) {
    setTextColor(
            ContextCompat.getColor(context, id)
    )
}


//MARK: - SnackBar

inline fun View.snack(
        message: String, length: Int = Snackbar.LENGTH_LONG, f: Snackbar.() -> Unit
) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}

fun Snackbar.textLines(maxLines: Int) {
    val snackBarView = view
    val textView = snackBarView.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
    textView.maxLines = maxLines
}

fun Snackbar.action(
        action: String, color: Int? = null, listener: (View) -> Unit
) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}

//MARK: - ViewGroup

val ViewGroup.children : List<View>
    get() = (0..childCount -1).map { getChildAt(it) }
