package news.agoda.com.technewssample.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import news.agoda.com.technewssample.BaseFragment;
import news.agoda.com.technewssample.R;
import news.agoda.com.technewssample.models.MultiMediumObject;
import news.agoda.com.technewssample.models.ResultObject;
import news.agoda.com.technewssample.utils.Utils;
import news.agoda.com.technewssample.widgets.CustomTextView;

/**
 * Created by aabid-personal on 3/10/16.
 */
public class DetailViewFragment extends BaseFragment {

    private static DetailViewFragment detailViewFragment;
    @Bind(R.id.newsImageView)
    ImageView newsImageView;
    @Bind(R.id.titleTextView)
    CustomTextView titleTextView;
    @Bind(R.id.descTextView)
    CustomTextView descTextView;
    private View parentView;
    private ResultObject selectedResultObject;

    private DetailViewFragment() {
        // to maintain singleton
    }

    public static DetailViewFragment getInstance(ResultObject resultObject) {
        detailViewFragment = new DetailViewFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("resultObject", resultObject);
        detailViewFragment.setArguments(bundle);
        return detailViewFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_detail_view, container, false);
        ButterKnife.bind(this, parentView);
        selectedResultObject = getArguments().getParcelable("resultObject");
        return parentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        titleTextView.setText(selectedResultObject.getTitle());
        descTextView.setText(selectedResultObject.get_abstract());

        List<MultiMediumObject> multiMediaList = selectedResultObject.getMultimedia();
        if (multiMediaList != null && multiMediaList.size() > 0) {

            ImageLoader.getInstance().displayImage(multiMediaList.get(0).getUrl(), newsImageView, Utils.getDisplayOptions());
            newsImageView.setVisibility(View.VISIBLE);
        } else {
            newsImageView.setVisibility(View.INVISIBLE);
        }

    }

    @OnClick(R.id.fullStoryButton)
    public void onFullStoryClicked() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(selectedResultObject.getUrl()));
        startActivity(intent);
    }

    @Override
    public boolean onBackPressConsumed() {
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
