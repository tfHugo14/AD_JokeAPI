package org.example.App;

import java.util.Map;

public class Joke {
    private boolean error;
    private String category;
    private String type;
    private String joke;
    private String setUp;
    private String delivery;
    private Map<Flags,Boolean> flags;
    private int id;
    private boolean safe;
    private String lang;

    public Joke(){}

    public Joke(boolean error, String category, String type, String joke, String setUp, String delivery, Map<Flags, Boolean> flags, int id, boolean safe, String lang) {
        this.error = error;
        this.category = category;
        this.type = type;
        this.joke = joke;
        this.setUp = setUp;
        this.delivery = delivery;
        this.flags = flags;
        this.id = id;
        this.safe = safe;
        this.lang = lang;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Joke: \n")
                .append(error ? "\terror: "+error+"\n" : "")
                .append("\tcategory: ").append(category).append("\n")
                .append("\ttype: ").append(type).append("\n")
                .append("\tjoke: ").append(joke).append("\n")
                .append("\tsetUp: ").append(setUp).append("\n")
                .append("\tdelivery: ").append(delivery).append("\n");
        sb.append("\tflags: \n");
        flags.forEach((key, value) -> { sb.append(value ? "\t\t" + key.getFlag() + ": " + value + "\n" : ""); });

        sb.append("\tid: ").append(id).append("\n")
        .append("\tsafe: ").append(safe).append("\n")
        .append("\tlang: ").append(lang).append("\n");

        return sb.toString();
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public void setSetUp(String setUp) {
        this.setUp = setUp;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public void setFlags(Map<Flags, Boolean> flags) {
        this.flags = flags;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}