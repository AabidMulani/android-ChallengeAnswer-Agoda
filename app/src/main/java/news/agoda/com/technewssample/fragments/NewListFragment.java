package news.agoda.com.technewssample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import news.agoda.com.technewssample.BaseFragment;

/**
 * Created by aabid-personal on 3/10/16.
 */
public class NewListFragment extends BaseFragment {

    private static NewListFragment newListFragment;

    private NewListFragment() {
        //Default Private Constructor
    }

    public static NewListFragment getInstance() {
        if (newListFragment == null) {
            newListFragment = new NewListFragment();
        }
        return newListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public boolean onBackPressConsumed() {
        return false;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public void reloadNewsList() {

    }

    public void populateOrUpdateList() {

    }

}
