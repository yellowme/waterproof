package mx.yellowme.waterproof.mvp.simple;

import android.support.annotation.NonNull;

import mx.yellowme.waterproof.mvp.BaseAdapter;
import mx.yellowme.waterproof.mvp.WaterproofViewHolder;

/**
 * Created by migdonio on 7/28/17.
 */

public abstract class SimpleAdapter<Item, CustomViewHolder extends WaterproofViewHolder>
        implements BaseAdapter {

    protected Item mItem;
    protected CustomViewHolder mViewHolder;
    protected SimpleWaterproofFragment mFragment;

    protected SimpleAdapter(
            @NonNull SimpleWaterproofFragment wpFragment,
            @NonNull CustomViewHolder wpViewHolder
    ){
        mFragment = wpFragment;
        mViewHolder = wpViewHolder;
        setupView(mViewHolder);
    }

    protected SimpleAdapter(
            Item item,
            @NonNull SimpleWaterproofFragment wpFragment,
            @NonNull CustomViewHolder wpViewHolder
            ){
        setItem(item);
        mFragment = wpFragment;
        mViewHolder = wpViewHolder;
        setupView(mViewHolder);
    }

    protected abstract void bindViews(CustomViewHolder mViewHolder);

    protected void setupView(CustomViewHolder mViewHolder) {
        if(getItem() == null) return;
        bindViews(mViewHolder);
    };

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
    protected void setItem(Item item) {
        mItem = item;
    }
}
