package mx.yellowme.waterproof.lists;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import static mx.yellowme.waterproof.WaterproofConditions.checkNotNull;

/**
 * Base for implement a list of filterable items using a filter criteria. This class uses
 * {@link FilterMethod} in order to execute a filter criteria over the list of items.
 */
public abstract class FilterableListAdapter<Item, CustomViewHolder extends RecyclerView.ViewHolder>
        extends ListAdapter<Item, CustomViewHolder>
        implements Filterable {

    /**
     * Helper for running animations when loading
     */
    private int lastAnimatedPosition = -1;

    /**
     * List containing only the filter items that pass filter criteria defined.
     */
    protected List<Item> mFilteredItemList;

    /**
     * Wrapper of {@link Filter} that allows to define a filter method criteria using the
     * class {@link FilterMethod} for a specific items set of the same type/model.
     */
    protected ItemFilter mFilter;

    /**
     * Class constructor.
     * @param items base list of items.
     * @param filterMethod filter criteria method.
     * @param itemListener listener that responds on item interaction.
     */
    public FilterableListAdapter(
            @NonNull List<Item> items,
            @NonNull FilterMethod<Item> filterMethod,
            @NonNull ItemListener<Item> itemListener
    ) {
        super(items, itemListener);
        mFilter = new ItemFilter(filterMethod);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        //runEnterAnimation(holder.itemView, position);
    }

    /**
     * Wrapper of {@link Filter} that allows to define a custom method for filtering.
     */
    private class ItemFilter extends Filter {

        /**
         * Method that implements a filter criteria based on conditionals.
         */
        FilterMethod<Item> mCondition;

        public ItemFilter(@NonNull FilterMethod<Item> condition){
            mCondition = checkNotNull(condition);
        }

        /**
         * This method is called automatically because the adapter implements {@link Filterable}
         * @param constraint text to be used as a base for the filtering method.
         * @return a set of results that matches filter criteria method.
         */
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterCriteria = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final List<Item> list = mItemList;

            int count = list.size();
            final ArrayList<Item> nlist = new ArrayList<Item>(count);

            Item filterableItem ;

            for (int i = 0; i < count; i++) {
                filterableItem = list.get(i);
                if (mCondition.evaluate(filterableItem, filterCriteria)) {
                    nlist.add(filterableItem);
                }
            }

            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mFilteredItemList = (ArrayList<Item>) results.values;
            notifyDataSetChanged();
        }

    }

    @Override
    protected void setList(List<Item> items) {
        mFilteredItemList = checkNotNull(items);
        mItemList = checkNotNull(items);;
    }

    @Override
    public int getItemCount() {
        return mFilteredItemList.size();
    }

    @Override
    public Item getItem(int position) {
        return mFilteredItemList.get(position);
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    /**
     * Defines a relation between a filter criteria and a domain object.
     * @param <Item> specific domain object to be evaluated with a text criteria.
     */
    public interface FilterMethod<Item> {

        boolean evaluate(Item filterableItem, String criteria);

    }

}
