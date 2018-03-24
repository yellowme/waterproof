package mx.yellowme.waterproof.mvp.simple

import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView

import mx.yellowme.waterproof.R
import mx.yellowme.waterproof.WaterproofFragment
import mx.yellowme.waterproof.mvp.WaterproofViewHolder
import org.jetbrains.anko.design.snackbar

abstract class SimpleWaterproofFragment<Model, ItemViewHolder : WaterproofViewHolder> : WaterproofFragment(), SimpleView<Model> {

    lateinit var mViewHolder: ItemViewHolder
    private var mEmptyState: RelativeLayout? = null

    protected lateinit var mActionsListener: SimplePresenter<Model>
    protected var mAdapter: SimpleAdapter<Model, ItemViewHolder>? = null

    protected open val mainContentView: ViewGroup?
        get() = null

    abstract val presenter: SimplePresenter<Model>
    protected abstract val emptyListMessage: String?

    override fun onResume() {
        super.onResume()
        mActionsListener.loadElement(true)
        mAdapter?.refreshView()
    }


    override fun setProgressIndicator(active: Boolean, blockInteraction: Boolean) {
        if (view == null) {
            return
        }
        val srl = view!!.findViewById<SwipeRefreshLayout>(R.id.wpRefreshLayout)

        // Make sure setRefreshing() is called after the layout is done with everything else.
        srl.post { srl.isRefreshing = active }
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

    override fun setupView(root: View) {
        super.setupView(root)
        setupEmptyStateContainer(root)
    }

    override fun bindViews(root: View) {
        mActionsListener = presenter
        mViewHolder = getConcreteItemViewHolder(root)
        setupAdapter()
    }

    override fun showElement(element: Model) {
        mAdapter!!.item = element
    }

    override fun setEmptyState(isEmpty: Boolean) {
        if (isEmpty) {
            mEmptyState!!.visibility = View.VISIBLE
        } else {
            mEmptyState!!.visibility = View.GONE
        }
    }

    fun setupEmptyStateContainer(root: View) {
        mEmptyState = root.findViewById(R.id.emptyStateContainer)
        if (mEmptyState != null && emptyListMessage != null) {
            (mEmptyState!!.findViewById<View>(R.id.wpEmptyStateMessage) as TextView).text = emptyListMessage
        }
    }

    protected abstract fun setupAdapter()

    abstract fun getConcreteItemViewHolder(root: View): ItemViewHolder
}
