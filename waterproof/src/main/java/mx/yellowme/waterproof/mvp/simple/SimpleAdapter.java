package mx.yellowme.waterproof.mvp.simple;

import android.content.Context;
import android.support.annotation.NonNull;

import mx.yellowme.waterproof.mvp.BaseAdapter;
import mx.yellowme.waterproof.mvp.lists.ItemListener;

import static mx.yellowme.waterproof.WaterproofConditions.checkNotNull;

/**
 * Created by migdonio on 7/28/17.
 */

public abstract class SimpleAdapter<Item>
        implements BaseAdapter {

    protected Item mItem;
    protected Context mContext;
    protected ItemListener<Item> mItemListener;

    protected SimpleAdapter(@NonNull Item item, @NonNull ItemListener<Item> itemListener){
        setItem(item);
        mItemListener = checkNotNull(itemListener);
    }

    protected void setItem(Item item) {
        mItem = item;
    }
    protected abstract void setupView();

    /**
     * Replace object on Adapter
     * @param item to replaced the current element.
     */
    public void replaceData(Item item) {
        //TODO: Search best way to notify like "notifyDataSetChanged();"
        setItem(item);
        setupView();
    }

    public Item getItem() {
        return mItem;
    }
}
