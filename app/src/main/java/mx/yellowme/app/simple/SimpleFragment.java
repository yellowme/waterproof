package mx.yellowme.app.simple;

import mx.yellowme.waterproof.mvp.simple.*;
import mx.yellowme.waterproof.mvp.simple.SimplePresenter;

/**
 * Created by migdonio on 8/1/17.
 */

public class SimpleFragment extends SimpleWaterproofFragment<SimpleFragment.Umbrella> {

    @Override
    public SimplePresenter<Umbrella> getPresenter() {
        return null;
    }

    @Override
    protected void setupAdapter() {

    }

    @Override
    protected String getEmptyListMessage() {
        return "No hay sombrillas";
    }

    public static class Umbrella {

    }
}
