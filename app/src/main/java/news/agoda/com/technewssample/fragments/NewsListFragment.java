package news.agoda.com.technewssample.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import news.agoda.com.technewssample.BaseFragment;
import news.agoda.com.technewssample.R;
import news.agoda.com.technewssample.activities.NewsMainScreenActivity;
import news.agoda.com.technewssample.adapters.NewsListRecyclerAdapter;
import news.agoda.com.technewssample.interfaces.OnNewsSelectedListener;
import news.agoda.com.technewssample.models.NewsDataModel;
import news.agoda.com.technewssample.models.ResultObject;
import news.agoda.com.technewssample.utils.NullStringToEmptyAdapterFactory;
import timber.log.Timber;

/**
 * Created by aabid-personal on 3/10/16.
 */
public class NewsListFragment extends BaseFragment implements OnNewsSelectedListener {

    private static NewsListFragment newsListFragment;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<ResultObject> allDataList;
    private View parentView;
    private NewsListRecyclerAdapter recyclerAdapter;

    private NewsListFragment() {
        //Default Private Constructor
    }

    public static NewsListFragment getInstance() {
        if (newsListFragment == null) {
            newsListFragment = new NewsListFragment();
        }
        return newsListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_main_list, container, false);
        ButterKnife.bind(this, parentView);
        return parentView;
    }

    @Override
    public boolean onBackPressConsumed() {
        return false;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        reloadNewsList();
    }

    public void reloadNewsList() {
        allDataList = getDataFromRawFile();
        if (allDataList != null) {
            populateOrUpdateList();
        } else {
            Snackbar.make(parentView, "Opps.. Something looks wrong..", Snackbar.LENGTH_LONG).show();
        }
    }

    private List<ResultObject> getDataFromRawFile() {
        Gson gson = new GsonBuilder().registerTypeAdapter(NewsDataModel.class, new NullStringToEmptyAdapterFactory()).create();
        NewsDataModel newsDataModels = gson.fromJson(loadResource(getActivity()), NewsDataModel.class);
        Timber.e(newsDataModels.toString());
        Timber.e(newsDataModels.getResults().size() + " SIZE");
        return newsDataModels.getResults();
    }


    public void populateOrUpdateList() {
        Timber.d("Reached populateOrUpdateList()");
        recyclerAdapter = new NewsListRecyclerAdapter(getActivity(), allDataList, this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onItemSelected(ResultObject resultObject) {
        //invoked when ever a news item is clicked
        DetailViewFragment detailViewFragment = DetailViewFragment.getInstance(resultObject);
        ((NewsMainScreenActivity) getActivity()).addThisFragment(detailViewFragment, true, true);
    }

    public String loadResource(Context context) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.news_list);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            InputStreamReader inputReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferReader = new BufferedReader(inputReader);
            int n;
            while ((n = bufferReader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            inputStream.close();
        } catch (IOException ioException) {
            return null;
        }

        return writer.toString();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
