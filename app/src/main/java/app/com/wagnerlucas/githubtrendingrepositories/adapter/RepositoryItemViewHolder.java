package app.com.wagnerlucas.githubtrendingrepositories.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.com.wagnerlucas.githubtrendingrepositories.R;

public class RepositoryItemViewHolder extends RecyclerView.ViewHolder{

    TextView tvTitle, tvForks, tvLanguage, tvDescription, tvStargazers;
    ImageView ivAvatarOwner;

    public RepositoryItemViewHolder(View view) {
        super(view);

        tvTitle = view.findViewById(R.id.repo_item_title);
        tvForks = view.findViewById(R.id.repo_item_fork);
        tvLanguage = view.findViewById(R.id.repo_item_language);
        tvDescription = view.findViewById(R.id.repo_item_description);
        tvStargazers = view.findViewById(R.id.repo_item_stargazers);
        ivAvatarOwner = view.findViewById(R.id.repo_item_avatar_owner);

    }
}
