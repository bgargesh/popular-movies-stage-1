package android.example.popular_movies_stage_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.popular_movies_stage_1.model.Movie;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayMovie extends AppCompatActivity {

    final static String IMAGE_URL = "https://image.tmdb.org/t/p/w780";
    static String MOVIE_KEY = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_movie);


        Intent fromPrevActivity = getIntent();
        Movie movie = fromPrevActivity.getParcelableExtra(MOVIE_KEY);

        Picasso.with(this).load(IMAGE_URL + movie.getPoster_path()).into((ImageView) findViewById(R.id.iv_movie_poster));

        TextView plotTextView = (TextView) findViewById(R.id.tv_plot);
        plotTextView.setText(movie.getOverview());
        TextView titleTextView = (TextView) findViewById(R.id.tv_title);
        titleTextView.setText(movie.getOriginal_name());
        TextView releasedOnTextView = (TextView) findViewById(R.id.tv_release_date);
        releasedOnTextView.setText("Released on: " + movie.getRelease_date());

        TextView ratingTextView = (TextView) findViewById(R.id.tv_rating);
        ratingTextView.setText("Rating: " + movie.getRating());

    }
}
