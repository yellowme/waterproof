package mx.yellowme.waterproof.mvp.activity

import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.TextView
import dagger.android.support.DaggerAppCompatActivity
import mx.yellowme.waterproof.R
import mx.yellowme.waterproof.mvp.WpView
import mx.yellowme.waterproof.utils.wpMakeGone
import mx.yellowme.waterproof.utils.wpMakeVisible
import org.jetbrains.anko.design.snackbar
import javax.inject.Inject

/**
 * Created by migdonio on 23/03/18.
 */
abstract class WpActivity<Presenter> : DaggerAppCompatActivity(), WpView {

    protected abstract val layout: Int

    protected open val mProgressBar: ProgressBar?
        get() = findViewById(R.id.progressBar)

    protected open val mProgressBarMessage: TextView?
        get() = findViewById(R.id.progressBarMessage)

    protected open val mainContentView: ViewGroup?
        get() = findViewById(android.R.id.content)

    protected open val progressBarMessage: String?
        get() = null

    protected abstract fun setupActivity()

    @JvmField @Inject
    var presenter : Presenter? = null

    override fun onDestroy() {
        super.onDestroy()
        presenter = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView(layout)
    }

    protected open fun setView(contentViewID: Int) {
        setContentView(contentViewID)
        setupActivity()
    }

    override fun setProgressIndicator(active: Boolean, blockInteraction: Boolean) {
        mProgressBar?.apply {
            if (active) {
                if(blockInteraction) {
                    window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
                }

                wpMakeVisible()
                mProgressBarMessage?.text = progressBarMessage ?: ""
            } else {
                if(blockInteraction) {
                    window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                }

                wpMakeGone()
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
