package mx.yellowme.app.simple;

import android.support.annotation.NonNull;

import mx.yellowme.waterproof.mvp.lists.ItemListener;
import mx.yellowme.waterproof.mvp.simple.SimpleAdapter;

import static mx.yellowme.waterproof.WaterproofConditions.checkNotNull;

/**
 * Created by migdonio on 8/1/17.
 */

public class UmbrellaAdapter extends SimpleAdapter<SimpleFragment.Umbrella> {
    protected UmbrellaAdapter(
            @NonNull SimpleFragment.Umbrella umbrella,
            @NonNull ItemListener<SimpleFragment.Umbrella> itemListener
    ) {
        super(umbrella, itemListener);
        mItemListener = checkNotNull(itemListener);
    }

    @Override
    protected void setupView() {

    }
}
