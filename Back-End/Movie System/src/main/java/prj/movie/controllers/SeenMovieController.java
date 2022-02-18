package prj.movie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prj.movie.data.Movie;
import prj.movie.data.User;
import prj.movie.services.impl.SeenMovieServiceDAO;
import prj.movie.services.impl.UserServiceDAO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("seenmovies")
public class SeenMovieController
{
    @Autowired
    SeenMovieServiceDAO seenMovieServiceDAO;

    @GetMapping("/{seenMovieDate}")
    public ResponseEntity seenMovieIntheDay(@PathVariable("seenMovieDate") String date)
    {
        List<String> movieListid= movieListid=seenMovieServiceDAO.searchByDate(date).getMovieid();


        return ResponseEntity.status(200).body(movieListid);

    }

}
