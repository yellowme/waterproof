package mx.yellowme.app.simple;

import android.util.Log;
import android.view.View;

import mx.yellowme.app.R;
import mx.yellowme.waterproof.mvp.simple.*;
import mx.yellowme.waterproof.mvp.simple.SimplePresenter;

/**
 * Created by migdonio on 8/1/17.
 */

public class UmbrellaFragment
        extends SimpleWaterproofFragment<Umbrella, UmbrellaViewHolder> {

    @Override
    public SimplePresenter<Umbrella> getPresenter() {
        return new UmbrellaPresenter(this);
    }

    @Override
    protected void setupAdapter() {
        mAdapter = new UmbrellaAdapter(this, mViewHolder);
    }

    @Override
    protected String getEmptyListMessage() {
        return "No hay sombrilla";
    }

    @Override
    public UmbrellaViewHolder getConcreteItemViewHolder(View root) {
        return new UmbrellaViewHolder(getContext(), root);
    }

    @Override
    public int getMainLayoutResource() {
        return R.layout.fragment_umbrella;
    }

}
