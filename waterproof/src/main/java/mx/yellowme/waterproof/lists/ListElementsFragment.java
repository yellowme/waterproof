package mx.yellowme.waterproof.lists;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import mx.yellowme.waterproof.R;

public abstract class ListElementsFragment<Model, ItemViewHolder extends RecyclerView.ViewHolder>
    extends WaterproofFragment
            implements ListElementsContract.View<Model> {

    protected ListElementsContract.Presenter<Model> mActionsListener;
    protected ListAdapter<Model, ItemViewHolder> mAdapter;
    protected LinearLayoutManager mLayoutManager;

    protected RecyclerView mRecyclerView;
    private RelativeLayout mEmptyState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mActionsListener.loadElements(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getMainLayoutResource() {
        return R.layout.waterproof_list_elements;
    }

    @Override
    public void setEmptyListState(boolean isEmpty) {
        //Log.d(TAG, "Change view elements visible");
        if(isEmpty){
            mRecyclerView.setVisibility(View.GONE);
            mEmptyState.setVisibility(View.VISIBLE);
        } else {
            mEmptyState.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void bindViews(View root) {
        setupRecyclerView(root);
        setupSwipeRefreshLayout(root);
        setupEmptyStateContainer(root);
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
        if(getView() == null){
            return;
        }
        //super.display(message);
    }

    @Override
    public void showElements(List<Model> elements) {
        mAdapter.replaceData(elements);
    }

    protected abstract void setupAdapter();

    protected abstract String getEmptyListMessage();

    protected void setupRecyclerView(View root) {
        mRecyclerView = root.findViewById(R.id.wpRecyclerView);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        /*mRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                mActionsListener.loadElements(true);
            }
        });*/
    }

    protected void setupSwipeRefreshLayout(View root) {
        SwipeRefreshLayout swipeRefreshLayout = root.findViewById(R.id.wpRefreshLayout);
        /*swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
        */swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mActionsListener.loadElements(true);
            }
        });
    }

    /**
     * Listener for clicks on notes in the RecyclerView.
     */
    protected ItemListener<Model> mItemListener = new ItemListener<Model>() {
        @Override
        public void onItemClick(Model clickedElement) {
            mActionsListener.openElement(clickedElement);
        }
    };

    public void setupEmptyStateContainer(View root) {
        mEmptyState = root.findViewById(R.id.emptyStateContainer);
        if(getEmptyListMessage() != null){
            ((TextView) mEmptyState.findViewById(R.id.wpEmptyStateMessage)).setText(
                    getEmptyListMessage()
            );
        }
    }
}
