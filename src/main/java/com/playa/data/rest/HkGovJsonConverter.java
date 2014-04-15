/**
 * 
 */
package com.playa.data.rest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import retrofit.converter.ConversionException;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedInput;

/**
 * The converter class that parse the activity ID list.
 * 
 * @author Jason Wong
 * 
 */
public class HkGovJsonConverter extends GsonConverter {

    private Gson gson;

    public HkGovJsonConverter() {
        super(new GsonBuilder().create());
        this.gson = new GsonBuilder().create();

    }

    public HkGovJsonConverter(Gson gson) {
        super(gson);

        this.gson = gson;
    }

    public HkGovJsonConverter(Gson gson, String encoding) {
        super(gson, encoding);

        this.gson = gson;

    }

    @Override
    public Object fromBody(TypedInput body, Type type)
            throws ConversionException {

        try {
            JsonParser parser = new JsonParser();
            Reader reader = new InputStreamReader(body.in());
            List<String> result = null;

            // Parse the response as a JSON array
            JsonArray array = parser.parse(reader).getAsJsonArray();

            // do the conversion
            if (array.size() > 0) {
                result = new ArrayList<String>();

                for (JsonElement ele : array) {
                    JsonArray entry = ele.getAsJsonArray();

                    // Getting the ID from the array
                    JsonElement id = entry.get(1);

                    result.add(this.gson.fromJson(id, String.class));
                }
            }

            return result;

        } catch (IOException e) {
            throw new ConversionException(e);
        }
    }

}
