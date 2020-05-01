package android.example.popular_movies_stage_1;

import android.example.popular_movies_stage_1.model.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private Movie[] movies;
    private MovieClickHandler movieClickHandler;

    interface MovieClickHandler {
        void onClick(Movie movie);
    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        final static String IMAGE_URL = "https://image.tmdb.org/t/p/w500";

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_movie_poster);
            itemView.setOnClickListener(this);
        }

        void bind(Movie movie) {
            Picasso.with(super.itemView.getContext()).load(IMAGE_URL + movie.getPoster_path()).into(imageView);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Movie display = movies[position];
            movieClickHandler.onClick(display);
        }
    }

    public MoviesAdapter(Movie [] movies, MovieClickHandler movieClickHandler) {
        this.movies = movies;
        this.movieClickHandler = movieClickHandler;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movies_list, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movies[position]);
    }

    public void setMoviesArray(Movie [] movies) {
        this.movies = movies;
    }

    @Override
    public int getItemCount() {
        return movies == null ? 0 : movies.length;
    }
}
