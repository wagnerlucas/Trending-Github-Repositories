package app.com.wagnerlucas.githubtrendingrepositories.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import app.com.wagnerlucas.githubtrendingrepositories.R;
import app.com.wagnerlucas.githubtrendingrepositories.adapter.RepositoryAdapter;
import app.com.wagnerlucas.githubtrendingrepositories.model.Owner;
import app.com.wagnerlucas.githubtrendingrepositories.model.Repository;
import app.com.wagnerlucas.githubtrendingrepositories.model.TrendingRepositories;
import app.com.wagnerlucas.githubtrendingrepositories.service.APIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private RepositoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(APIService.BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

        APIService service = retrofit.create(APIService.class);
        Call<TrendingRepositories> requestRepositories = service.getTrendingRepositories();

        requestRepositories.enqueue(new Callback<TrendingRepositories>() {
            @Override
            public void onResponse(Call<TrendingRepositories> call, Response<TrendingRepositories> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Couldn't connect to servers!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    TrendingRepositories repositoriesList = response.body();

                    recyclerView = findViewById(R.id.listTrendingRepositories);
                    adapter = new RepositoryAdapter(getApplicationContext(), repositoriesList.items);

                    layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.addItemDecoration(new DividerItemDecoration(
                            getApplicationContext(), LinearLayoutManager.HORIZONTAL));
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<TrendingRepositories> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Connection error!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
