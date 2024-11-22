package org.example.App;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.Adapters.JokeAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class JokeDAO implements IJokeDAO{
    @Override
    public Joke getJoke() {
        Type tipoJoke = new TypeToken<Joke>() {}.getType();

        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(tipoJoke, new JokeAdapter());
        Gson gson = gsonBuilder.create();
        Joke joke = new Joke();
        try {
            URL url = new URI("https://v2.jokeapi.dev/joke/Any?lang=es").toURL();
            InputStream is = url.openConnection().getInputStream();
            BufferedReader urlReader = new BufferedReader(new InputStreamReader(is));
            joke = gson.fromJson(urlReader, Joke.class);
            urlReader.close();
        } catch (URISyntaxException | IOException ignored) {}
        return joke;
    }

    @Override
    public Joke getJokeByLang(String lang) {
        Type tipoJoke = new TypeToken<Joke>() {}.getType();

        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(tipoJoke, new JokeAdapter());
        Gson gson = gsonBuilder.create();
        Joke joke = new Joke();
        try {
            URL url = new URI("https://v2.jokeapi.dev/joke/Any?lang="+lang).toURL();
            InputStream is = url.openConnection().getInputStream();
            BufferedReader urlReader = new BufferedReader(new InputStreamReader(is));
            joke = gson.fromJson(urlReader, Joke.class);
            urlReader.close();
        } catch (URISyntaxException | IOException ignored) {}
        return joke;
    }

    @Override
    public Joke getJokeByCategory(String category) {
        Type tipoJoke = new TypeToken<Joke>() {}.getType();

        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(tipoJoke, new JokeAdapter());
        Gson gson = gsonBuilder.create();
        Joke joke = new Joke();
        try {
            URL url = new URI("https://v2.jokeapi.dev/joke/"+category+"?lang=en").toURL();
            InputStream is = url.openConnection().getInputStream();
            BufferedReader urlReader = new BufferedReader(new InputStreamReader(is));
            joke = gson.fromJson(urlReader, Joke.class);
            urlReader.close();
        } catch (URISyntaxException | IOException ignored) {}
        return joke;
    }
}
