package prj.movie.repositories;

import prj.movie.services.IGenericDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import prj.movie.data.Address;
import prj.movie.data.Contact;

import java.sql.Date;
import java.util.List;

public interface IContactDAO extends JpaRepository<Contact,String>
{
    /*@Query("SELECT c FROM Contact c WHERE c.name=?1")
    List<Contact> searchByName(String name);
*/
   /* @Query("DELETE FROM Contact WHERE name =?1")
    void deleteByName(String name);*/

    @Transactional
    @Modifying
    @Query("UPDATE Contact c SET c.name=?1,c.birthday=?2," +
            "c.email=?3,c.gender=?4 " +
            "WHERE c.userid=?5")
    void updateByName(String name,Date birthday, String email, String gender,String userid);

}
