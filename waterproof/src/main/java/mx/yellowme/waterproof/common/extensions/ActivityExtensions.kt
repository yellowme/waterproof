package mx.yellowme.waterproof.common.extensions

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import mx.yellowme.waterproof.R


/**
 * Created by luisburgos on 9/20/17.
 */

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun FragmentActivity.findFragment(frameId: Int): Fragment? {
    val fragment = supportFragmentManager.findFragmentById(frameId)
    return fragment
}

fun FragmentActivity.addFragment(fragment: Fragment, frameId: Int){
    supportFragmentManager.inTransaction {
        add(frameId, fragment)
    }
}

fun FragmentActivity.replaceFragment(fragment: Fragment, frameId: Int, masterDetail: Boolean = false, backStackKey: String? = null) {
    if(supportFragmentManager.backStackEntryCount > 0) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    supportFragmentManager.inTransaction{
        if(masterDetail) {
            setCustomAnimations(
                    R.anim.slide_in_from_right,
                    R.anim.slide_out_to_left,
                    R.anim.slide_in_from_left,
                    R.anim.slide_out_to_right
            )
        }
        replace(frameId, fragment)
        backStackKey?.let {
            addToBackStack(it)
        }
    }
}

fun Fragment.showKeyboardOn(editText: EditText) { activity.showKeyboardOn(editText) }

fun FragmentActivity.showKeyboardOn(editText: EditText) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
}