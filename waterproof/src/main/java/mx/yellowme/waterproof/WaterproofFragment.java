package mx.yellowme.waterproof;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class WaterproofFragment
        extends Fragment
            implements WaterproofView {

    protected Messenger realMessenger = new Messenger(); //TODO: Maybe pass default strategy

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getMainLayoutResource(), container, false);
        this.setupView(root);
        return root;
    }

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

    public void setupView(View root) {
        bindViews(root);
    };

}
