package mx.yellowme.waterproof.mvp.simple;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import mx.yellowme.waterproof.R;
import mx.yellowme.waterproof.WaterproofFragment;

public abstract class SimpleWaterproofFragment<Model>
        extends WaterproofFragment
        implements SimpleView<Model>{

    private RelativeLayout mEmptyState;

    protected SimplePresenter<Model> mActionsListener;
    protected SimpleAdapter<Model> mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAdapter();
        mActionsListener = getPresenter();
        /*setupActionListener();*/
    }

    public abstract SimplePresenter<Model> getPresenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mActionsListener.loadElement(true);
    }

    @Override
    public void setProgressIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }
        final SwipeRefreshLayout srl = getView().findViewById(R.id.wpRefreshLayout);

        // Make sure setRefreshing() is called after the layout is done with everything else.
        srl.post(new Runnable() {
            @Override
            public void run() {
                srl.setRefreshing(active);
            }
        });
    }

    @Override
    public void display(String message) {
        display(message, null);
    }

    @Override
    public void display(String message, MessageAction action) {
        if (action == null) {
            realMessenger.setStrategy(new MessageNotifierStrategy() {
                @Override
                public void showMessage(View view, String message, MessageAction action) {
                    Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                }
            });
        } else {
            realMessenger.setStrategy(new MessageNotifierStrategy() {
                @Override
                public void showMessage(View view, String message, final MessageAction action) {
                    Snackbar sn = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
                    sn.setAction("Action", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            action.execute();
                        }
                    });
                }
            });
        }

        realMessenger.deliver(getView(), message, action);
    }

    @Override
    public int getMainLayoutResource() {
        return R.layout.waterproof_simple_fragment;
    }

    @Override
    public void bindViews(View root) {
        setupEmptyStateContainer(root);
    }

    @Override
    public void showElement(Model model) {
        mAdapter.setItem(model);
    }

    @Override
    public void setEmptyState(boolean isEmpty) {
        if(isEmpty){
            mEmptyState.setVisibility(View.VISIBLE);
        } else {
            mEmptyState.setVisibility(View.GONE);
        }
    }

    public void setupEmptyStateContainer(View root) {
        mEmptyState = root.findViewById(R.id.emptyStateContainer);
        if(getEmptyListMessage() != null){
            ((TextView) mEmptyState.findViewById(R.id.wpEmptyStateMessage)).setText(
                    getEmptyListMessage()
            );
        }
    }

    protected abstract void setupAdapter();
    protected abstract String getEmptyListMessage();
}
