package mx.yellowme.app;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import mx.yellowme.waterproof.mvp.lists.ListWaterproofFragment;
import mx.yellowme.waterproof.mvp.lists.ListElementsPresenter;


public class ListFragment
        extends ListWaterproofFragment<ListFragment.MyModel, ListFragment.MyViewHolder> {

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public ListElementsPresenter<MyModel> getPresenter() {
        return new ListPresenter(
                this
        );
    }

    @Override
    protected void setupAdapter() {
        //TODO: Create ADAPTER extending LIST ADAPTER
    }

    @Override
    protected String getEmptyListMessage() {
        return null;
    }

    public static class MyModel {

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
