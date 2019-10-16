package app.com.wagnerlucas.githubtrendingrepositories.model;

import java.io.Serializable;
import java.util.List;

public class TrendingRepositories implements Serializable {

    public List<Repository> items;

    public TrendingRepositories(List<Repository> items) {
        this.items = items;
    }


}
