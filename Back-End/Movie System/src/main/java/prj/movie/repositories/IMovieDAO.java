package prj.movie.repositories;

import prj.movie.data.Movie;
import prj.movie.data.SeenMovie;
import prj.movie.services.IGenericDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface IMovieDAO extends JpaRepository<Movie,String> {
    @Query("SELECT m from Movie m WHERE m.title=?1")
    List<Movie> searchByName(String name);
    @Query("SELECT m from Movie m WHERE m.externalId=?1")
    List<Movie> searchById(String id);
    /*@Query("DELETE from Movie WHERE external_id=?1")
    void deleteByExternal_id(String id);*/

    @Transactional
    @Modifying
    @Query("UPDATE Movie m SET m.title=?1, " +
            "m.added=?2,m.seenMovie=?3 WHERE m.externalId=?3")
    void updateById(String title, Date added, SeenMovie seenMovie, String id);
}
