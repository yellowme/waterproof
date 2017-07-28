package mx.yellowme.waterproof;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public abstract class WaterproofFragment
        extends Fragment
            implements WaterproofView {

    protected Messenger realMessenger = new Messenger(); //TODO: Maybe pass default strategy

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public class Messenger {
        private MessageNotifierStrategy strategy;

        public void setStrategy(MessageNotifierStrategy strategy) {
            this.strategy = strategy;
        }

        public void deliver(View mView, String mMessage, MessageAction mAction) {
            strategy.showMessage(mView, mMessage, mAction);
        }
    }

    public interface MessageNotifierStrategy {
        void showMessage(View view, String message, MessageAction action);
    }

}
