package news.agoda.com.technewssample.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import news.agoda.com.technewssample.R;
import news.agoda.com.technewssample.interfaces.OnNewsSelectedListener;
import news.agoda.com.technewssample.models.MultiMediumObject;
import news.agoda.com.technewssample.models.ResultObject;
import news.agoda.com.technewssample.utils.Utils;
import news.agoda.com.technewssample.widgets.CustomTextView;

/**
 * Created by aabid-personal on 3/11/16.
 */
public class NewsListRecyclerAdapter extends RecyclerView.Adapter<NewsListRecyclerAdapter.CustomViewHolder> {
    private List<ResultObject> resultObjectList;
    private Context mContext;
    private OnNewsSelectedListener onNewsSelectedListener;

    public NewsListRecyclerAdapter(Context context, List<ResultObject> resultObjectList,
                                   OnNewsSelectedListener onNewsSelectedListener) {
        this.resultObjectList = resultObjectList;
        this.mContext = context;
        this.onNewsSelectedListener = onNewsSelectedListener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inflater_news_item, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int position) {
        final ResultObject resultObject = resultObjectList.get(position);
        customViewHolder.newsTitle.setText(Html.fromHtml(resultObject.getTitle()));
        List<MultiMediumObject> multiMediaList = resultObject.getMultimedia();
        if (multiMediaList != null && multiMediaList.size() > 0) {
            MultiMediumObject mediaEntity = multiMediaList.get(0);
            customViewHolder.newsItemImage.setVisibility(View.VISIBLE);


            ImageLoader.getInstance().displayImage(mediaEntity.getUrl(), customViewHolder.newsItemImage, Utils.getDisplayOptions());

        } else {
            //this means that the mediaEntityList is empty so HIDE the image view
            customViewHolder.newsItemImage.setVisibility(View.INVISIBLE);
        }

        customViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNewsSelectedListener.onItemSelected(resultObject);
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultObjectList.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.cardView)
        CardView cardView;
        @Bind(R.id.news_item_image)
        ImageView newsItemImage;
        @Bind(R.id.news_title)
        CustomTextView newsTitle;

        CustomViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
