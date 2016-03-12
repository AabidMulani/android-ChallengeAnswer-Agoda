package news.agoda.com.technewssample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aabid-personal on 3/11/16.
 */
public class NewsDataModel {


    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;

    @SerializedName("results")
    @Expose
    private List<ResultObject> results = new ArrayList<ResultObject>();

    public NewsDataModel(String status, String copyright, String section, String lastUpdated, Integer numResults, List<ResultObject> results) {
        this.status = status;
        this.copyright = copyright;
        this.section = section;
        this.lastUpdated = lastUpdated;
        this.numResults = numResults;
        this.results = results;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public void setResults(List<ResultObject> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getSection() {
        return section;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public List<ResultObject> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "NewsDataModel{" +
                "status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", section='" + section + '\'' +
                ", lastUpdated='" + lastUpdated + '\'' +
                ", numResults=" + numResults +
                ", results=" + results +
                '}';
    }
}
