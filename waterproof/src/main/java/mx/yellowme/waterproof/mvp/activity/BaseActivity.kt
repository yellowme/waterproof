package mx.yellowme.waterproof.mvp.activity

import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import dagger.android.support.DaggerAppCompatActivity
import mx.yellowme.waterproof.R
import mx.yellowme.waterproof.mvp.BaseView
import mx.yellowme.waterproof.utils.WPmakeGone
import mx.yellowme.waterproof.utils.WPmakeVisible
import org.jetbrains.anko.design.snackbar
import javax.inject.Inject

/**
 * Created by migdonio on 23/03/18.
 */
abstract class BaseActivity<Presenter> : DaggerAppCompatActivity(), BaseView {

    protected open val mProgressBar: ProgressBar?
        get() = findViewById(progressBarId)

    protected open val mProgressBarMessage: TextView?
        get() = findViewById(progressBarMessageId)

    protected abstract val layout: Int

    protected open val mainContentView: ViewGroup?
        get() = findViewById(android.R.id.content)

    protected open val progressBarMessage: String?
        get() = null

    protected open val progressBarId: Int
        get() = R.id.progressBar

    protected open val progressBarMessageId: Int
        get() = R.id.progressBarMessage

    @JvmField @Inject
    var mPresenter : Presenter? = null

    override fun onDestroy() {
        super.onDestroy()
        mPresenter = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView(layout)
    }

    protected open fun setView(contentViewID: Int) {
        setContentView(contentViewID)
        bindViews()
        setupActivity()
    }

    protected abstract fun setupActivity()

    protected abstract fun bindViews()

    override fun setProgressIndicator(active: Boolean, blockInteraction: Boolean) {
        mProgressBar?.apply {
            if (active) {
                if(blockInteraction) {
                    window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }

                WPmakeVisible()
                mProgressBarMessage?.text = progressBarMessage ?: ""
            } else {
                if(blockInteraction) {
                    window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                }

                WPmakeGone()
            }
        }
    }

    override fun display(message: String) {
        mainContentView?.let { snackbar(it, message) }
    }

    override fun display(message: String, actionText: String, action: () -> Unit) {
        mainContentView?.let {
            snackbar(it, message, actionText, {
                action()
            })
        }
    }
}
