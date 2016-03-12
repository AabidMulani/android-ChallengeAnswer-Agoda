package news.agoda.com.technewssample.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aabid-personal on 3/11/16.
 */
public class ResultObject implements Parcelable {

    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("subsection")
    @Expose
    private String subsection;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("abstract")
    @Expose
    private String _abstract;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("item_type")
    @Expose
    private String itemType;
    @SerializedName("updated_date")
    @Expose
    private String updatedDate;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("material_type_facet")
    @Expose
    private String materialTypeFacet;
    @SerializedName("kicker")
    @Expose
    private String kicker;
    @SerializedName("multimedia")
    @Expose
    private List<MultiMediumObject> multimedia = new ArrayList<MultiMediumObject>();

    public ResultObject(String title, String _abstract, String url, List<MultiMediumObject> multimedia) {
        this.title = title;
        this._abstract = _abstract;
        this.url = url;
        this.multimedia = multimedia;
    }

    public String getSection() {
        return section;
    }

    public String getSubsection() {
        return subsection;
    }

    public String getTitle() {
        return title;
    }

    public String get_abstract() {
        return _abstract;
    }

    public String getUrl() {
        return url;
    }

    public String getByline() {
        return byline;
    }

    public String getItemType() {
        return itemType;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getMaterialTypeFacet() {
        return materialTypeFacet;
    }

    public String getKicker() {
        return kicker;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void set_abstract(String _abstract) {
        this._abstract = _abstract;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setMaterialTypeFacet(String materialTypeFacet) {
        this.materialTypeFacet = materialTypeFacet;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    public void setMultimedia(List<MultiMediumObject> multimedia) {
        this.multimedia = multimedia;
    }

    public List<MultiMediumObject> getMultimedia() {
        return multimedia;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.section);
        dest.writeString(this.subsection);
        dest.writeString(this.title);
        dest.writeString(this._abstract);
        dest.writeString(this.url);
        dest.writeString(this.byline);
        dest.writeString(this.itemType);
        dest.writeString(this.updatedDate);
        dest.writeString(this.createdDate);
        dest.writeString(this.publishedDate);
        dest.writeString(this.materialTypeFacet);
        dest.writeString(this.kicker);
        dest.writeTypedList(multimedia);
    }

    public ResultObject() {
    }

    protected ResultObject(Parcel in) {
        this.section = in.readString();
        this.subsection = in.readString();
        this.title = in.readString();
        this._abstract = in.readString();
        this.url = in.readString();
        this.byline = in.readString();
        this.itemType = in.readString();
        this.updatedDate = in.readString();
        this.createdDate = in.readString();
        this.publishedDate = in.readString();
        this.materialTypeFacet = in.readString();
        this.kicker = in.readString();
        this.multimedia = in.createTypedArrayList(MultiMediumObject.CREATOR);
    }

    public static final Parcelable.Creator<ResultObject> CREATOR = new Parcelable.Creator<ResultObject>() {
        public ResultObject createFromParcel(Parcel source) {
            return new ResultObject(source);
        }

        public ResultObject[] newArray(int size) {
            return new ResultObject[size];
        }
    };


}
