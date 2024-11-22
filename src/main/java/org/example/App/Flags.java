package org.example.App;

public enum Flags {
    NSFW("nsfw"),
    RELIGIOUS("religious"),
    POLITICAL("political"),
    RACIST("racist"),
    SEXIST("sexist"),
    EXPLICIT("explicit");

    private String flag;

    Flags(String flag) {
        this.flag = flag;
    }
    public String getFlag() {
        return flag;
    }
}
