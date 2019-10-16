package app.com.wagnerlucas.githubtrendingrepositories.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.com.wagnerlucas.githubtrendingrepositories.R;
import app.com.wagnerlucas.githubtrendingrepositories.model.Repository;
import app.com.wagnerlucas.githubtrendingrepositories.model.TrendingRepositories;
import app.com.wagnerlucas.githubtrendingrepositories.view.DetailViewActivity;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryItemViewHolder>{

    private List<Repository> repositoriesList;
    private Context context;

    public RepositoryAdapter(Context context, List<Repository> repositoriesList){
        this.repositoriesList = repositoriesList;
        this.context = context;
    }

    public Repository getItem(int position){
        return repositoriesList.get(position);
    }

    @Override
    public RepositoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repository_item, parent, false);

        return new RepositoryItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RepositoryItemViewHolder holder, int position) {

        final Repository repository = repositoriesList.get(position);
        holder.tvTitle.setText(repository.getName());
        holder.tvDescription.setText(repository.getDescription());
        holder.tvForks.setText(String.valueOf(repository.getForks()));
        holder.tvStargazers.setText(String.valueOf(repository.getStargazers_count()));
        holder.tvLanguage.setText(repository.getLanguage());

        Picasso.with(context).load(repository.getOwner().getAvatar_url()).into(holder.ivAvatarOwner);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailViewActivity.class);
                i.putExtra("Repository",repository);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return repositoriesList.size();
    }

}
