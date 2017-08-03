package mx.yellowme.app.simple;

import android.support.annotation.NonNull;
import android.util.Log;

import mx.yellowme.waterproof.mvp.simple.SimpleAdapter;
import mx.yellowme.waterproof.mvp.simple.SimpleWaterproofFragment;

/**
 * Created by migdonio on 8/1/17.
 */

public class UmbrellaAdapter extends SimpleAdapter<Umbrella, UmbrellaViewHolder> {

    protected UmbrellaAdapter(
            @NonNull Umbrella umbrella,
            @NonNull SimpleWaterproofFragment wpFragment,
            @NonNull UmbrellaViewHolder wpViewHolder
    ) {
        super(umbrella, wpFragment, wpViewHolder);
    }

    @Override
    protected void setupView(UmbrellaViewHolder mViewHolder) {
        Log.d("holis uvh", "setupView");
        if(mItem == null) {
            return;
        }

        Log.d("holistryhard", mItem.getColor());

        mViewHolder.umbrellaPriceTextView.setText(String.valueOf(mItem.getPrice()));
        mViewHolder.umbrellaColorTextView.setText(mItem.getColor());
    }
}
