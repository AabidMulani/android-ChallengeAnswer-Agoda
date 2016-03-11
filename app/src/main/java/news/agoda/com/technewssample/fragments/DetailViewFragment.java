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
public class DetailViewFragment extends BaseFragment {

    private static DetailViewFragment detailViewFragment;

    private DetailViewFragment() {
        // to maintain singleton
    }

    public static DetailViewFragment getInstance() {
        if (detailViewFragment == null) {
            detailViewFragment = new DetailViewFragment();
        }
        return detailViewFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public boolean onBackPressConsumed() {
        return false;
    }
}
