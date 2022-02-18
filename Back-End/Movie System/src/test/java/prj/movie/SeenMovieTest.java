package prj.movie;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import prj.movie.Exceptions.AlreadyExistingException;
import prj.movie.data.*;
import prj.movie.repositories.IMovieDAO;
import prj.movie.services.impl.MovieServiceDAO;
import prj.movie.services.impl.SeenMovieServiceDAO;
import prj.movie.services.impl.UserServiceDAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class SeenMovieTest
{
    private static final Logger logger = LoggerFactory.getLogger(SeenMovieTest.class);
    @Autowired
    SeenMovieServiceDAO seenMovieServiceDAO;

    @Autowired
    UserServiceDAO userServiceDAO;

    @Test
    public void addTest() throws AlreadyExistingException {
        List<String> movieids = new ArrayList<String>();
        movieids.add("001");
        SeenMovie seenMovie = new SeenMovie("2022-03-05",movieids);
        seenMovieServiceDAO.add(seenMovie);

        User user=new User("123","whoami",seenMovie,
                new Contact("123","AJ",
                        Date.valueOf("1995-03-08"),
                        "M","abc@test.com"));
        userServiceDAO.add(user);
    }

    @Test
    public void getAll()
    {
        for (SeenMovie sm:seenMovieServiceDAO.getAll())
        {
            logger.info(sm.toString());

        }
    }

}
