package org.example.App;

public interface IJokeDAO {
    Joke getJoke();
    Joke getJokeByLang(String lang);
    Joke getJokeByCategory(String category);
}
