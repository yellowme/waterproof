package mx.yellowme.app.simple;

import mx.yellowme.waterproof.mvp.simple.SimplePresenter;
import mx.yellowme.waterproof.mvp.simple.SimpleView;

/**
 * Created by migdonio on 8/1/17.
 */

public class UmbrellaPresenter
        extends SimplePresenter<Umbrella> {
    public UmbrellaPresenter(SimpleView mView) {
        super(mView);
    }

    @Override
    public void loadElement(boolean forceUpdate) {
        // load by Database or Rest API
        Umbrella umbrella = createDummyUmbrella();
        mView.showElement(umbrella);
    }

    private Umbrella createDummyUmbrella() {
        Umbrella umbrella = new Umbrella();
        umbrella.setColor("Blue");
        umbrella.setPrice(239.99);

        return umbrella;
    };
}
