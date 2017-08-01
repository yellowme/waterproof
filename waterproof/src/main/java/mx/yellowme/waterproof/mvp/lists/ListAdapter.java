package mx.yellowme.waterproof.mvp.lists;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import mx.yellowme.waterproof.mvp.BaseAdapter;

import static mx.yellowme.waterproof.WaterproofConditions.checkNotNull;

/**
 * Base class to implement a RecyclerView based list. In order to use this class
 * is necessary to implement a Custom ViewHolder over which the adapter is going to operate.
 */
public abstract class ListAdapter<Item, CustomViewHolder extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<CustomViewHolder>
        implements BaseAdapter {

    protected List<Item> mItemList;
    protected Context mContext;
    protected ItemListener<Item> mItemListener;

    protected ListAdapter(@NonNull List<Item> itemList, @NonNull ItemListener<Item> itemListener){
        setList(itemList);
        mItemListener = checkNotNull(itemListener);
    }

    /**
     * Replaces all the objects of the current list on adapter.
     * @param users list of object to replaced the current list.
     */
    public void replaceData(List<Item> users) {
        setList(users);
        notifyDataSetChanged();
    }

    /**
     * Adds more objects to current list on adapter.
     * @param users list of new objects to be added to the current list.
     */
    public void addData(List<Item> users) {
        addToList(users);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public Item getItem(int position) {
        return mItemList.get(position);
    }

    /**
     * Helper method to interact with the item list variable.
     */
    protected void setList(List<Item> elements) {
        mItemList = checkNotNull(elements);
    }

    /**
     * Helper method to interact with the item list variable.
     */
    protected void addToList(List<Item> elements) {
        checkNotNull(elements);
        mItemList.addAll(elements);
    }

    public List<Item> getItems() {
        return mItemList;
    }
}
