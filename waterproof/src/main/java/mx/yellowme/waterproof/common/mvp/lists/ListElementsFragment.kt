package mx.yellowme.waterproof.common.mvp.lists

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.component_list.*
import kotlinx.android.synthetic.main.component_list_empty_state.*
import mx.yellowme.waterproof.R
import mx.yellowme.waterproof.common.adapter.BindableViewHolder
import mx.yellowme.waterproof.common.adapter.InfiniteScrollListener
import mx.yellowme.waterproof.common.adapter.ListAdapter
import mx.yellowme.waterproof.common.mvp.fragment.BaseFragment

/**
 *
 * Created by luisburgos on 9/20/17.
 */
abstract class ListElementsFragment<Model, ItemViewHolder : BindableViewHolder<Model>>: BaseFragment(), ListElementsContract.View<Model> {

    protected abstract var presenter: ListElementsContract.Presenter<Model>?
    protected var adapter: ListAdapter<Model, ItemViewHolder>? = null

    //MARK: Empty View

    protected var emptyActionTitle: String? = null
    protected var emptyAction: (() -> Unit)? = null
    protected abstract var emptyMessage: String?

    protected abstract fun bindAdapter(): ListAdapter<Model, ItemViewHolder>?

    open var canSwipeToRefresh: Boolean = true
    open var swipeToRefreshColors: SwipeColors? = null

    //MARK: Fragment

    override val layout: Int?
        get() = R.layout.component_list

    override fun configureViews() {
        adapter = bindAdapter()
        recyclerView()
        swipeRefreshLayout()
        emptyStateContainer()
    }

    override fun onResume() {
        super.onResume()
        presenter?.load(true)
    }

    //MARK: API

    fun setListPadding(left: Int, top: Int, right: Int, bottom: Int){
        recyclerView?.setPadding(left, top, right, bottom)
    }

    //MARK: View

    override fun empty(isEmpty: Boolean) {
        if (isEmpty) {
            recyclerView?.visibility = View.GONE
            emptyStateContainer?.visibility = View.VISIBLE
        } else {
            emptyStateContainer?.visibility = View.GONE
            recyclerView?.visibility = View.VISIBLE
        }
    }

    override fun setProgress(active: Boolean) {
        if (view == null) {
            return
        }
        // Make sure setRefreshing() is called after the layout is done with everything else.
        swipeRefresh?.post { swipeRefresh?.isRefreshing = active }
    }

    override fun show(elements: MutableList<Model>) {
        Log.d(javaClass.simpleName, "Loading elements " + elements.size)
        adapter?.replaceData(elements)
        adapter?.notifyDataSetChanged()
    }

    override fun showMore(elements: MutableList<Model>) {
        adapter?.addData(elements)
    }

    //MARK: Setup

    private fun recyclerView() {
        recyclerView?.let {
            it.adapter = adapter

            it.setHasFixedSize(true)
            val concreteLayoutManager = LinearLayoutManager(context)
            it.layoutManager = concreteLayoutManager
            it.addOnScrollListener(InfiniteScrollListener({
                presenter?.load(true)
            }, concreteLayoutManager))
        }
    }

    private fun swipeRefreshLayout() {
        swipeRefresh?.apply {
            swipeToRefreshColors?.let {
                setColorSchemeColors(
                        it.p1, it.p2, it.p3
                )
            }
            setOnRefreshListener {
                presenter?.load(true)
            }
        }
        swipeRefresh.isEnabled = canSwipeToRefresh
    }

    private fun emptyStateContainer() {
        message?.let {
            emptyMessage?.let {
                message.visibility = View.VISIBLE
                message.text = it
            }
        }

        action?.let {
            emptyAction?.let {
                action.visibility = View.VISIBLE

                emptyActionTitle?.let {
                    action.text = it
                    action.setOnClickListener {
                        emptyAction?.invoke()
                    }
                }
            }
        }
    }
}