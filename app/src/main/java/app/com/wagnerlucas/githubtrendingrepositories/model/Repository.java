package app.com.wagnerlucas.githubtrendingrepositories.model;

import java.io.Serializable;

public class Repository implements Serializable{

    public String name, description, html_url, language, created_at;
    public int id, watchers, forks, open_issues, stargazers_count;
    public Owner owner;

    public Repository(String name, String description, String html_url,
                      String language, String created_at, int id,
                      int watchers, int forks, int open_issues, int stargazers_count, Owner owner) {
        this.name = name;
        this.description = description;
        this.html_url = html_url;
        this.language = language;
        this.created_at = created_at;
        this.id = id;
        this.watchers = watchers;
        this.forks = forks;
        this.open_issues = open_issues;
        this.stargazers_count = stargazers_count;
        this.owner = owner;
    }

    public Repository(){

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getLanguage() {
        return language;
    }

    public String getCreated_at() {
        return created_at;
    }

    public int getId() {
        return id;
    }

    public int getWatchers() {
        return watchers;
    }

    public int getForks() {
        return forks;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public Owner getOwner() {
        return owner;
    }
}
