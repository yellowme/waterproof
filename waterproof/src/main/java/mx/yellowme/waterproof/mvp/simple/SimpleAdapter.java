package mx.yellowme.waterproof.mvp.simple;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import mx.yellowme.waterproof.R;
import mx.yellowme.waterproof.WaterproofFragment;
import mx.yellowme.waterproof.mvp.BaseAdapter;
import mx.yellowme.waterproof.mvp.WaterproofViewHolder;
import mx.yellowme.waterproof.mvp.lists.ItemListener;

import static mx.yellowme.waterproof.WaterproofConditions.checkNotNull;

/**
 * Created by migdonio on 7/28/17.
 */

public abstract class SimpleAdapter<Item, CustomViewHolder extends WaterproofViewHolder>
        implements BaseAdapter {

    protected Item mItem;
    protected Context mContext;
    protected ItemListener<Item> mItemListener;
    protected CustomViewHolder mViewHolder;
    protected View mView;
    protected SimpleWaterproofFragment mFragment;

    protected SimpleAdapter(
            @NonNull Item item,
            @NonNull SimpleWaterproofFragment wpFragment,
            @NonNull CustomViewHolder wpViewHolder
            ){
        setItem(item);
        mFragment = wpFragment;
        mViewHolder = wpViewHolder;
        setupView(mViewHolder);
    }

    protected void setItem(Item item) {
        mItem = item;
    }
    protected abstract void setupView(CustomViewHolder mViewHolder);

    /**
     * Replace object on Adapter
     * @param item to replaced the current element.
     */
    public void replaceData(Item item) {
        //TODO: Search best way to notify like "notifyDataSetChanged();"
        setItem(item);
        setupView(mViewHolder);
    }

    public void refreshView() {
        setupView(mViewHolder);
    }

    public Item getItem() {
        return mItem;
    }
}
