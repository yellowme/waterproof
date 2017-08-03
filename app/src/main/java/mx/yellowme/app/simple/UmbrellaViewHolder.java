package mx.yellowme.app.simple;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import mx.yellowme.app.R;
import mx.yellowme.waterproof.mvp.WaterproofViewHolder;

/**
 * Created by migdonio on 8/2/17.
 */

public class UmbrellaViewHolder implements WaterproofViewHolder {

    TextView umbrellaColorTextView;
    TextView umbrellaPriceTextView;

    UmbrellaViewHolder(Context context, View rootView) {
        umbrellaColorTextView = rootView.findViewById(R.id.umbrellaColorTextView);
        umbrellaPriceTextView = rootView.findViewById(R.id.umbrellaPriceTextView);
    }
}
