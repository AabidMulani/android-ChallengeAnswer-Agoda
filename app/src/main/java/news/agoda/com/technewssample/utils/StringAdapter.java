package news.agoda.com.technewssample.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by aabid-personal on 3/12/16.
 */

public class StringAdapter extends TypeAdapter<String> {
    public String read(JsonReader reader) throws IOException {
        return reader.nextString();
    }

    public void write(JsonWriter writer, String value) throws IOException {
        if (value.equals("")) {
            writer.nullValue();
            return;
        }
        writer.value(value);
    }
}
