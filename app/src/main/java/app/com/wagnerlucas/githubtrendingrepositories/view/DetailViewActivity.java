package app.com.wagnerlucas.githubtrendingrepositories.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import app.com.wagnerlucas.githubtrendingrepositories.R;
import app.com.wagnerlucas.githubtrendingrepositories.model.Repository;

public class DetailViewActivity extends AppCompatActivity {

    private TextView tvLogin, tvName, tvDescription, tvWatchers, tvStar, tvFork, tvOpenIssues,
                    tvLanguage, tvCreatedAt;
    private ImageView ivAvatar;
    private Button btnViewOnGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        Intent intent = getIntent();

        final Repository repository = (Repository) intent.getSerializableExtra("Repository");

        tvLogin = findViewById(R.id.detail_login);
        tvName = findViewById(R.id.detail_name);
        tvDescription = findViewById(R.id.detail_description);
        tvWatchers = findViewById(R.id.detail_watchers);
        tvStar = findViewById(R.id.detail_stargazzers);
        tvFork = findViewById(R.id.detail_fork);
        tvOpenIssues = findViewById(R.id.detail_open_issues);
        tvLanguage = findViewById(R.id.detail_language);
        tvCreatedAt = findViewById(R.id.detail_created_at);
        ivAvatar = findViewById(R.id.detail_avatar);
        btnViewOnGithub = findViewById(R.id.btn_view_on_github);

        btnViewOnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uriUrl = Uri.parse(repository.getHtml_url());
                Intent i = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(i);
            }
        });

        tvLogin.setText(repository.getOwner().getLogin());
        tvName.setText(repository.getName());
        tvDescription.setText(repository.getDescription());
        tvWatchers.setText(String.valueOf(repository.getWatchers()));
        tvStar.setText(String.valueOf(repository.getStargazers_count()));
        tvFork.setText(String.valueOf(repository.getForks()));
        tvOpenIssues.setText(String.valueOf(repository.getOpen_issues()));
        tvLanguage.setText(repository.getLanguage());

        int x = repository.getCreated_at().indexOf('T');
        tvCreatedAt.setText(repository.getCreated_at().substring(0,x));

        Picasso.with(getApplicationContext()).load(repository.getOwner().getAvatar_url()).into(ivAvatar);

    }
}
