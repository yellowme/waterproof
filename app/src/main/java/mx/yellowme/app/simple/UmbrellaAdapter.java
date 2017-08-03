package mx.yellowme.app.simple;

import android.support.annotation.NonNull;

import mx.yellowme.waterproof.mvp.simple.SimpleAdapter;
import mx.yellowme.waterproof.mvp.simple.SimpleWaterproofFragment;

/**
 * Created by migdonio on 8/1/17.
 */

public class UmbrellaAdapter extends SimpleAdapter<Umbrella, UmbrellaViewHolder> {

    protected UmbrellaAdapter(
            @NonNull SimpleWaterproofFragment wpFragment,
            @NonNull UmbrellaViewHolder wpViewHolder
    ) {
        super(wpFragment, wpViewHolder);
    }

    @Override
    protected void bindViews(UmbrellaViewHolder mViewHolder) {
        mViewHolder.umbrellaPriceTextView.setText(String.valueOf(mItem.getPrice()));
        mViewHolder.umbrellaColorTextView.setText(mItem.getColor());
    }
}
