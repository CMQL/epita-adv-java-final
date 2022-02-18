package prj.movie.repositories;

import prj.movie.data.User;
import prj.movie.services.IGenericDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import prj.movie.data.*;
import prj.movie.data.Contact;
import prj.movie.data.Role;

import java.util.List;

public interface IUserDAO extends JpaRepository<User,String> {
    @Query("SELECT u from User u WHERE u.username=?1")
    List<User> searchByName(String name);

    /*@Query("DELETE from User WHERE userid=?1")
    void deleteByUserid(String id);*/

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.username=?1, " +
            "u.seenMovie=?2," +
            "u.contact=?3 WHERE u.userid=?4")
    void updateById(String name, SeenMovie seenMovie
            , Contact contact, String id);
}
