package mx.yellowme.waterproof.common.mvp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.yellowme.waterproof.R
import mx.yellowme.waterproof.common.extensions.inflate
import mx.yellowme.waterproof.common.mvp.BaseView
import org.jetbrains.anko.support.v4.progressDialog

/**
 * Created by luisburgos on 9/20/17.
 */
abstract class BaseFragment : Fragment(), BaseView {

    protected var mainViewGroup: ViewGroup? = null

    protected abstract val layout: Int?

    protected var progressMessage: String? = null

    //MARK: Fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layout?.let {
            return container?.inflate(it)
        }
        return null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        configureViews()
    }

    //MARK: Layout

    open fun configureViews() {
        mainViewGroup = activity?.findViewById<ViewGroup>(android.R.id.content)
    }

    //MARK: Base View

    override fun setProgress(active: Boolean) {
        val dialog = progressDialog(progressMessage?: getString(R.string.waterproof_loading))
        if (active) dialog.show() else dialog.hide()
    }

    override fun display(message: String) {

    }

    override fun display(message: String, listener: (() -> Unit)?, actionTitle: String?) {

    }
}