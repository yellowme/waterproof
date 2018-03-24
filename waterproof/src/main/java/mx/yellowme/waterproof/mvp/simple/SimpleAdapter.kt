package mx.yellowme.waterproof.mvp.simple

import mx.yellowme.waterproof.mvp.BaseAdapter
import mx.yellowme.waterproof.mvp.WaterproofViewHolder

/**
 * Created by migdonio on 7/28/17.
 */

abstract class SimpleAdapter<Item, CustomViewHolder : WaterproofViewHolder> : BaseAdapter {

    var item: Item? = null
    protected var mViewHolder: CustomViewHolder
    protected var mFragment: SimpleWaterproofFragment<*, *>

    protected constructor(
            wpFragment: SimpleWaterproofFragment<*, *>,
            wpViewHolder: CustomViewHolder
    ) {
        mFragment = wpFragment
        mViewHolder = wpViewHolder
        setupView(mViewHolder)
    }

    protected constructor(
            item: Item,
            wpFragment: SimpleWaterproofFragment<*, *>,
            wpViewHolder: CustomViewHolder
    ) {
        this.item = item
        mFragment = wpFragment
        mViewHolder = wpViewHolder
        setupView(mViewHolder)
    }

    protected abstract fun bindViews(mViewHolder: CustomViewHolder)

    protected fun setupView(mViewHolder: CustomViewHolder) {
        if (item == null) return
        bindViews(mViewHolder)
    }

    /**
     * Replace object on Adapter
     * @param item to replaced the current element.
     */
    fun replaceData(item: Item) {
        //TODO: Search best way to notify like "notifyDataSetChanged();"
        this.item = item
        setupView(mViewHolder)
    }

    fun refreshView() {
        setupView(mViewHolder)
    }
}
