package app.com.wagnerlucas.githubtrendingrepositories.service;

import app.com.wagnerlucas.githubtrendingrepositories.model.TrendingRepositories;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    public static final String BASE_URL = "https://api.github.com/";

    @GET("search/repositories?q=android%20language:java&sort=stars&order=desc&per_page=50")
    Call<TrendingRepositories> getTrendingRepositories();
}
