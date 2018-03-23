package mx.yellowme.waterproof.common.adapter

import android.content.Context
import java.util.*

/**
 * Base for implement a list of filterable items using a filter criteria. This class uses
 * "FilterMethod" in order to execute a filter criteria over the list of items.
 */
abstract class FilterableListAdapter<Item, ConcreteViewHolder : BindableViewHolder<Item>>(
        context: Context,
        listener: (Item) -> Unit
) : ListAdapter<Item, ConcreteViewHolder>(context, listener) {

    /**
     * List containing only the filter items that pass filter criteria defined.
     */
    internal var filteredItems: List<Item> = mutableListOf()

    abstract fun filterMethod(filterableItem: Item, criteria: String): Boolean

    fun filter(constraint: CharSequence): ArrayList<Item> {
        val filterCriteria = constraint.toString().toLowerCase()
        val list = items

        val count = list?.size
        val nList = arrayListOf<Item>()

        var filterableItem: Item

        count?.let {
            for (i in 0..it.minus(1)) {
                filterableItem = list[i]

                if (filterMethod(filterableItem, filterCriteria)) {
                    nList.add(filterableItem)
                }
            }
        }

        filteredItems = nList
        notifyDataSetChanged()

        return nList
    }

    override fun setList(elements: List<Item>) {
        super.setList(elements)
        filteredItems = elements
    }

    override fun getItemCount(): Int {
        return filteredItems.size
    }

}