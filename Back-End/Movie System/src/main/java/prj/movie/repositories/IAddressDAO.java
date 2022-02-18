package prj.movie.repositories;

import prj.movie.data.Contact;
import prj.movie.services.IGenericDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import prj.movie.data.Address;

public interface IAddressDAO extends JpaRepository<Address,String>
{
    @Transactional
    @Modifying
    @Query("UPDATE Address a SET a.name=?1," +
            "a.country=?2,a.area=?3," +
            "a.city=?4,a.street=?5," +
            "a.number=?6,a.contact=?7 WHERE a.userid=?8")
    void updateByName(String name, String country, String area, String city, String street, String number, Contact contact,String userid);
}
