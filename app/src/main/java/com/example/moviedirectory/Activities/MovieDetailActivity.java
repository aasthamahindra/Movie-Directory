package com.example.moviedirectory.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.moviedirectory.Model.Movie;
import com.example.moviedirectory.R;
import com.example.moviedirectory.Util.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.PrimitiveIterator;

public class MovieDetailActivity extends AppCompatActivity {

    private Movie movie;
    private TextView movieTitle;
    private ImageView movieImage;
    private TextView movieYear;
    private TextView director;
    private TextView actors;
    private TextView category;
    private TextView rating;
    private TextView writers;
    private TextView plot;
    private TextView boxOffice;
    private TextView runtime;

    private RequestQueue  queue;
    private String movieId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movie = (Movie) getIntent().getSerializableExtra("movie");
        movieId = movie.getImdbId();
        
        setUpUI();
        getMovieDetails(movieId);
    }

    private void getMovieDetails(String id) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                Constants.URL_ID + id + Constants.API_KEY, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonObjectRequest);
    }

    private void setUpUI() {

        movieTitle = (TextView) findViewById(R.id.movieTitleDet);
        movieImage = (ImageView) findViewById(R.id.movieImageIDDet);
        movieYear = (TextView) findViewById(R.id.movieReleaseDet);
        director = (TextView) findViewById(R.id.directedByDet);
        category = (TextView) findViewById(R.id.movieCatDet);
        rating = (TextView) findViewById(R.id.movieRatingIDDet);
        writers = (TextView) findViewById(R.id.writersDet);
        plot = (TextView) findViewById(R.id.plotDet);
        boxOffice = (TextView) findViewById(R.id.boxOfficeDet);
        runtime = (TextView) findViewById(R.id.runtimeDet);
        actors = (TextView) findViewById(R.id.actorsDet);

    }
    
}