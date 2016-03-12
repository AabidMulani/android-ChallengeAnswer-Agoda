package news.agoda.com.technewssample.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import news.agoda.com.technewssample.models.MultiMediumObject;
import news.agoda.com.technewssample.models.NewsDataModel;
import news.agoda.com.technewssample.models.ResultObject;
import timber.log.Timber;

public class NullStringToEmptyAdapterFactory extends TypeAdapter<NewsDataModel> {

    @Override
    public void write(JsonWriter out, NewsDataModel value) throws IOException {
        out.beginObject();
        if (value.getResults().toString().equals("")) {
            out.name("results");
            out.nullValue();
        }

        /* similar check for otherObject */
        out.endObject();
    }

    @Override
    public NewsDataModel read(JsonReader reader) throws IOException {
        String status = null, copyright = null, section = null, last_updated = null;
        int num_results = 0;
        List<ResultObject> resultsObjectList = new ArrayList<>();

        JsonParser parser = new JsonParser();
        JsonObject jsonObj = (JsonObject) parser.parse(reader);

        if (jsonObj.has("status")) {
            status = jsonObj.get("status").getAsString();
        }
        if (jsonObj.has("copyright")) {
            copyright = jsonObj.get("copyright").getAsString();
        }
        if (jsonObj.has("section")) {
            section = jsonObj.get("section").getAsString();
        }
        if (jsonObj.has("last_updated")) {
            last_updated = jsonObj.get("last_updated").getAsString();
        }
        if (jsonObj.has("num_results")) {
            num_results = jsonObj.get("num_results").getAsInt();
        }
        if (jsonObj.has("results")) {
            Timber.e("Found Result");
            try {
                if (jsonObj.get("results") instanceof JsonArray) {
                    JsonArray resultRawJsonArray = jsonObj.get("results").getAsJsonArray();
                    for (int i = 0; i < resultRawJsonArray.size(); i++) {
                        String title = null;
                        String _abstract = null;
                        String url = null;
                        List<MultiMediumObject> multiMediumObjectList = new ArrayList<>();

                        JsonObject jsonObject = resultRawJsonArray.get(i).getAsJsonObject();
                        if (jsonObject.has("title")) {
                            title = jsonObject.get("title").getAsString();
                        }

                        if (jsonObject.has("abstract")) {
                            _abstract = jsonObject.get("abstract").getAsString();
                        }

                        if (jsonObject.has("url")) {
                            url = jsonObject.get("url").getAsString();
                        }

                        if (jsonObject.has("multimedia")) {
                            Timber.e("Inside Multimedia");
                            if (jsonObject.get("multimedia") instanceof JsonArray) {
                                JsonArray rawMultimedia = jsonObject.get("multimedia").getAsJsonArray();
                                if (rawMultimedia != null && !rawMultimedia.toString().equals("")) {
                                    Type listType = new TypeToken<List<MultiMediumObject>>() {
                                    }.getType();
                                    multiMediumObjectList = (List<MultiMediumObject>) new Gson().fromJson(rawMultimedia, listType);
                                    Timber.e(multiMediumObjectList.size() + ".....");
                                }
                            }
                        }

                        ResultObject object = new ResultObject(title, _abstract, url, multiMediumObjectList);
                        resultsObjectList.add(object);
                        Timber.e("Result IS JSON ARRAY");
                    }
                } else {
                    Timber.e("Result was not a json array");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }


        return new NewsDataModel(status, copyright, section, last_updated, num_results, resultsObjectList);
    }
}