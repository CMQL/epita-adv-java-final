package prj.movie.DTOs;

import prj.movie.data.Movie;
import prj.movie.data.User;

import java.util.List;

public class SeenMovieDTO
{
    List<User> usersIntheDate;
    List<Movie> moviesSeenIntheDate;

    public SeenMovieDTO() {
    }

    public SeenMovieDTO(List<User> usersIntheDate, List<Movie> moviesSeenIntheDate) {
        this.usersIntheDate = usersIntheDate;
        this.moviesSeenIntheDate = moviesSeenIntheDate;
    }

    public List<User> getUsersIntheDate() {
        return usersIntheDate;
    }

    public void setUsersIntheDate(List<User> usersIntheDate) {
        this.usersIntheDate = usersIntheDate;
    }

    public List<Movie> getMoviesSeenIntheDate() {
        return moviesSeenIntheDate;
    }

    public void setMoviesSeenIntheDate(List<Movie> moviesSeenIntheDate) {
        this.moviesSeenIntheDate = moviesSeenIntheDate;
    }

    @Override
    public String toString() {
        return "SeenMovieDTO{" +
                "usersIntheDate=" + usersIntheDate +
                ", moviesSeenIntheDate=" + moviesSeenIntheDate +
                '}';
    }
}
