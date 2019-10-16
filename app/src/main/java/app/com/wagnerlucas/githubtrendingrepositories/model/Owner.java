package app.com.wagnerlucas.githubtrendingrepositories.model;

import java.io.Serializable;

public class Owner implements Serializable {
    public int id;
    public String avatar_url, login;

    public Owner(int id, String avatar_url, String login) {
        this.id = id;
        this.avatar_url = avatar_url;
        this.login = login;
    }

    public Owner(){

    }

    public int getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getLogin() {
        return login;
    }
}
