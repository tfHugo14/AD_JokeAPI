package org.example.Adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.example.App.Flags;
import org.example.App.Joke;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JokeAdapter extends TypeAdapter<Joke> {
    @Override
    public void write(JsonWriter jsonWriter, Joke joke) throws IOException {

    }

    @Override
    public Joke read(JsonReader reader) throws IOException {
        Joke joke = new Joke();
        reader.beginObject();

        while (reader.hasNext()){
            String value = reader.nextName();
            switch (value) {
                case "error"    :  joke.setError(reader.nextBoolean()); break;
                case "category" :  joke.setCategory(reader.nextString()); break;
                case "type"     :  joke.setType(reader.nextString()); break;
                case "joke"     :  joke.setJoke(reader.nextString()); break;
                case "setup"    :  joke.setSetUp(reader.nextString()); break;
                case "delivery" :  joke.setDelivery(reader.nextString()); break;
                case "flags"    :  joke.setFlags(readFlags(reader)); break;
                case "id"       :  joke.setId(reader.nextInt()); break;
                case "safe"     :  joke.setSafe(reader.nextBoolean()); break;
                case "lang"     :  joke.setLang(reader.nextString()); break;
                default : reader.skipValue();
            }
        }
        reader.endObject();
        return joke;
    }

    public Map<Flags,Boolean> readFlags(JsonReader reader) throws IOException {
        Map<Flags,Boolean> flags = new HashMap<>();
        reader.beginObject();
        while (reader.hasNext()){
            String value = reader.nextName();
            switch (value) {
                case "explicit"  : flags.put(Flags.EXPLICIT,reader.nextBoolean()); break;
                case "nsfw"      : flags.put(Flags.NSFW,reader.nextBoolean()); break;
                case "political" : flags.put(Flags.POLITICAL,reader.nextBoolean()); break;
                case "racist"    : flags.put(Flags.RACIST,reader.nextBoolean()); break;
                case "religious" : flags.put(Flags.RELIGIOUS,reader.nextBoolean()); break;
                case "sexist"    : flags.put(Flags.SEXIST,reader.nextBoolean()); break;
                default : reader.skipValue();
            }
        }
        reader.endObject();
        return flags;
    }
}
