package prj.movie.repositories;

import prj.movie.data.Movie;
import prj.movie.data.SeenMovie;
import prj.movie.data.User;
import prj.movie.services.IGenericDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface ISeenMovieDAO extends JpaRepository<SeenMovie,String>
{
    @Query("SELECT s from SeenMovie s WHERE s.date=?1")
    SeenMovie searchByDate(String date);

    @Query("DELETE from SeenMovie WHERE date=?1")
    void deleteByDate(Date date);


}
