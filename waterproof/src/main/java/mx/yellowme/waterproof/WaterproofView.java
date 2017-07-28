package mx.yellowme.waterproof;

import android.view.View;

import mx.yellowme.waterproof.mvp.BaseView;

public interface WaterproofView extends BaseView {
    int getMainLayoutResource();
    void bindViews(View root);
}
