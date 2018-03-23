package mx.yellowme.waterproof.common.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.DecelerateInterpolator
import mx.yellowme.waterproof.common.utils.Utils

/**
 * Base class to implement a RecyclerView based list. In order to use this class
 * is necessary to implement a Custom ViewHolder over which the adapter is going to operate.
 */
abstract class ListAdapter<Item, ConcreteViewHolder : BindableViewHolder<Item>>(
        val context: Context,
        val listener: (Item) -> Unit
) : RecyclerView.Adapter<ConcreteViewHolder>() {

    /**
     * Helper for running animations when loading
     */
    private var lastAnimatedPosition = -1

    var items: List<Item>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    open var animateEnter: Boolean = false

    override fun onBindViewHolder(holder: ConcreteViewHolder, position: Int) {
        if(animateEnter) { runEnterAnimation(holder.itemView, position) }

        items?.let {
            val current = it[position]
            (holder as? BindableViewHolder<Item>)?.apply {
                bind(current)
            }
        }
    }

    /**
     * Replaces all the objects of the current list on adapter.
     * @param elements list of object to replaced the current list.
     */
    fun replaceData(elements: List<Item>) {
        setList(elements)
    }

    /**
     * Adds more objects to current list on adapter.
     * @param elements list of new objects to be added to the current list.
     */
    fun addData(elements: List<Item>) {
        addToList(elements)
    }

    /**
     * Total elements on the adapter
     */
    override fun getItemCount(): Int {
        return items?.size?: 0
    }

    /**
     * Helper method to interact with the item list variable.
     */
    open fun setList(elements: List<Item>) {
        addToList(elements)
    }

    /**
     * Helper method to interact with the item list variable.
     */
    open fun addToList(elements: List<Item>) {
        items = elements
    }

    private fun runEnterAnimation(view: View, position: Int) {
        if (position > lastAnimatedPosition) {
            lastAnimatedPosition = position
            view.translationY = Utils.getScreenHeight(context);
            view.animate()
                    .translationY(0f)
                    .setInterpolator(DecelerateInterpolator(3f))
                    .setDuration(700)
                    .start()
        }
    }
}
