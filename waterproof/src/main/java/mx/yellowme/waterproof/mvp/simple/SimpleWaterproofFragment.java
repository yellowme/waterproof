package mx.yellowme.waterproof.mvp.simple;

import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import mx.yellowme.waterproof.R;
import mx.yellowme.waterproof.WaterproofFragment;
import mx.yellowme.waterproof.mvp.WaterproofViewHolder;

public abstract class SimpleWaterproofFragment<Model, ItemViewHolder extends WaterproofViewHolder>
        extends WaterproofFragment
        implements SimpleView<Model> {

    public ItemViewHolder mViewHolder;
    private RelativeLayout mEmptyState;

    protected SimplePresenter<Model> mActionsListener;
    protected SimpleAdapter<Model, ItemViewHolder> mAdapter;

    @Override
    public void onResume() {
        super.onResume();
        mActionsListener.loadElement(true);
        mAdapter.refreshView();
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
    public void setupView(View root) {
        super.setupView(root);
        setupEmptyStateContainer(root);
    }

    @Override
    public void bindViews(View root) {
        mActionsListener = getPresenter();
        mViewHolder = getConcreteItemViewHolder(root);
        setupAdapter();
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
        if(mEmptyState != null && getEmptyListMessage() != null){
            ((TextView) mEmptyState.findViewById(R.id.wpEmptyStateMessage)).setText(
                    getEmptyListMessage()
            );
        }
    }

    public abstract SimplePresenter<Model> getPresenter();

    protected abstract void setupAdapter();
    protected abstract String getEmptyListMessage();

    public abstract ItemViewHolder getConcreteItemViewHolder(View root);
}
