package mx.yellowme.waterproof.common.mvp.activty

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import mx.yellowme.waterproof.R
import mx.yellowme.waterproof.common.extensions.action
import mx.yellowme.waterproof.common.extensions.guard
import mx.yellowme.waterproof.common.extensions.snack
import mx.yellowme.waterproof.common.extensions.textLines
import mx.yellowme.waterproof.common.mvp.BaseView
import org.jetbrains.anko.progressDialog

/**
 * This class allows you to:
 * - Display messages with SnackBar
 * - Setups main_actions content layout
 * - View on MVP
 * - Facilitates bind elements

 * Created by luisburgos on 10/5/16.
 */
abstract class BaseActivityView : AppCompatActivity(), BaseView {

    protected var mainViewGroup: ViewGroup? = null

    protected var progressMessage: String? = null

    //MARK: UI Setup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
    }

    protected fun setView() {
        layout?.let {
            setContentView(it)
        }
        setupMainLayout()
    }

    protected fun setupMainLayout() {
        mainViewGroup.guard {
            mainViewGroup = findViewById<View>(android.R.id.content) as ViewGroup
        }
    }

    //MARK: Generics

    protected abstract val layout: Int?

    //MARK: API

    open fun display(largeMessage: String, maxLines: Int) {
        mainViewGroup?.snack(largeMessage) {
            textLines(maxLines)
        }
    }

    //MARK: Base View

    override fun setProgress(active: Boolean) {
        val dialog = progressDialog(progressMessage?: getString(R.string.waterproof_loading))
        if (active) dialog.show() else dialog.hide()
    }

    override fun display(message: String) {
        display(Snackbar.LENGTH_LONG, message, null, null)
    }

    override fun display(message: String, listener: (() -> Unit)?, actionTitle: String?) {
        display(Snackbar.LENGTH_INDEFINITE, message, listener, actionTitle)
    }

    //MARK: Helpers

    private fun display(duration: Int, message: String, listener: (() -> Unit)? = null, actionTitle: String? = null) {
        mainViewGroup?.snack(message, duration) {
            actionTitle?.let {
                action(it) {
                    listener?.invoke()
                }
            }
        }
    }

}