package mx.yellowme.waterproof.common.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Base implementation of fragment pager adapter,
 * Created by luisburgos on 8/30/16.
 */
abstract class BasePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    /**
     * Current fragment item.
     */
    var currentItem: Int = 0

    /**
     * All fragment pages.
     */
    private var mItems: IntArray? = null

    /**
     * Total count of pages.
     */
    private var totalItems: Int = 0

    override fun getCount(): Int {
        return totalItems
    }

    fun setItems(newItems: IntArray) {
        mItems = newItems
        totalItems = mItems?.size as Int
    }

}