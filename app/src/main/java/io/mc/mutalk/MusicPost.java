package io.mc.mutalk;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import java.io.IOException;

public class MusicPost {
    private String id;
    private String author;
    private String comment;
    private Integer like;
    private Integer start;
    private Integer end;

    public MusicPost(String id, String author, String comment, Integer like) {
        this.id = id;
        this.author = author;
        this.comment = comment;
        this.like = like;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        String apiKey = BuildConfig.GOOGLE_API_KEY;
        YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new GsonFactory(), (HttpRequest request) -> {
        }).setApplicationName("Your App Name").build();

        try {
            // Create the search query
            YouTube.Videos.List search = youtube.videos()
                    .list("snippet")
                    .setFields("items(snippet/title)")
                    .setKey(apiKey)
                    .setId(this.id);
            // Execute the API request
            ResponseTask task = new ResponseTask();
            VideoListResponse response = task.execute(search).get();
            // Get the title of the video
            String title = response.getItems().get(0).getSnippet().getTitle();
            return title;
        } catch (Exception e) {
            System.err.println("Something went wrong: " + e);
        }

        return "Dummy-" + id;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public Integer getLike() {
        return like;
    }

    public void setTime(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }
}

class ResponseTask extends AsyncTask<YouTube.Videos.List, Void, VideoListResponse> {
    public VideoListResponse result;

    @Override
    protected VideoListResponse doInBackground(YouTube.Videos.List... params) {
        try {
            result = params[0].execute();
            return result;
        } catch (Exception e) {
            System.err.println("Something went wrong: " + e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(VideoListResponse result) {
        this.result = result;
    }

    public VideoListResponse getResult() {
        return result;
    }
}