package prj.movie.services.impl;

import org.springframework.stereotype.Service;
import prj.movie.Exceptions.AlreadyExistingException;
import prj.movie.data.Movie;
import prj.movie.data.SeenMovie;
import prj.movie.data.User;
import prj.movie.repositories.ISeenMovieDAO;
import prj.movie.services.IGenericDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import prj.movie.repositories.IMovieDAO;
import prj.movie.repositories.IUserDAO;

import java.sql.Date;
import java.util.List;

@Service
public class SeenMovieServiceDAO implements IGenericDAO<SeenMovie>
{
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceDAO.class);
    @Autowired
    ISeenMovieDAO seenMovieDAO;

    @Autowired
    MovieServiceDAO movieDAO;

    @Autowired
    UserServiceDAO userDAO;

    @Override
    public boolean hasDuplicate(SeenMovie seenMovie) {
       //logger.info("try");
        //logger.info(seenMovieDAO.searchByDate("2018-05-11").toString());

        return seenMovieDAO.findById(seenMovie.getDate()).isPresent();
    }

    @Override
    public List<SeenMovie> getAll() {
        return seenMovieDAO.findAll();
    }

    @Override
    public void add(SeenMovie seenMovie) throws AlreadyExistingException {
        if(!hasDuplicate(seenMovie))
        {
            seenMovieDAO.save(seenMovie);
            logger.info("Seen Movie created");
        }
        else
        {
            throw new AlreadyExistingException("Seen Movie already exists");
        }
    }

    @Override
    public void update(SeenMovie seenMovie) {
        logger.info("Seen Movie is not allowed to update");
    }
    public SeenMovie searchByDate(String date)
    {
        return seenMovieDAO.searchByDate(date);
    }
    public void deleteByDate(Date date)
    {
        seenMovieDAO.deleteByDate(date);
    }

}
