package prj.movie.services.impl;

import prj.movie.Exceptions.AlreadyExistingException;
import prj.movie.data.Movie;
import prj.movie.repositories.IMovieDAO;
import prj.movie.services.IGenericDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceDAO implements IGenericDAO<Movie> {
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceDAO.class);

    @Autowired
    IMovieDAO movieDAO;



    @Override
    public List<Movie> getAll() {
        return movieDAO.findAll();
    }

    @Override
    public void add(Movie movie) throws AlreadyExistingException {
        if(!hasDuplicate(movie))
        {
            movieDAO.save(movie);
            logger.info("Movie created");
        }
        else
        {
            throw new AlreadyExistingException("Movie already exists");
        }
    }

    @Override
    public void update(Movie movie) {
        if(hasDuplicate(movie))
        {
            movieDAO.updateById(movie.getTitle(),movie.getAdded(),movie.getSeenMovie(),movie.getExternalId());
        }
        else
        {
            logger.info("No such movie");
        }
    }
    public Movie searchById(String id) {
        return movieDAO.getById(id);
    }
    public List<Movie> searchByName(String name) {
        return movieDAO.searchByName(name);
    }

    public void delete(String id) {
        movieDAO.deleteById(id);
    }
    @Override
    public boolean hasDuplicate(Movie movie) {
        return movieDAO.findById(movie.getExternalId()).isPresent();
    }
}
