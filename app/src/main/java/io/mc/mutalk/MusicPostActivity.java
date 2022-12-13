package io.mc.mutalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MusicPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_post);

        //
        Intent mIntent = getIntent();
        String id = mIntent.getStringExtra("id");
        String title = mIntent.getStringExtra("title");
        String author = mIntent.getStringExtra("author");
        String comment = mIntent.getStringExtra("comment");
        Integer like = mIntent.getIntExtra("like", 0);

        // initialize WebView
        WebView videoView = findViewById(R.id.videoView);
        String videoUrl = "https://www.youtube.com/embed/" + id + "?autoplay=1";
        videoView.getSettings().setJavaScriptEnabled(true);
        Log.d("APP-DEBUG", videoUrl);
        videoView.loadUrl(videoUrl);

        // initialize TextViews
        TextView tvTitle = findViewById(R.id.postName);
        tvTitle.setText(title);
        TextView tvAuthor = findViewById(R.id.postAuthor);
        tvAuthor.setText(author);
        TextView tvComment = findViewById(R.id.postComment);
        tvComment.setText(comment);

        ImageButton likeButton = findViewById(R.id.likeButton);
        likeButton.setImageResource(R.drawable.ic_thumbup_inactive);
        TextView likeCount = findViewById(R.id.likeCount);
        likeCount.setText(like.toString());

        likeButton.setOnClickListener(view -> {
            likeButton.setImageResource(R.drawable.ic_thumbup_active);
            Integer newLike = like + 1;
            likeCount.setText(newLike.toString());
        });
    }
}