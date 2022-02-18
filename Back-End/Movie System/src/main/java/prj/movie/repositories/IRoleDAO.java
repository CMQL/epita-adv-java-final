package prj.movie.repositories;

import prj.movie.data.User;
import prj.movie.services.IGenericDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import prj.movie.data.Role;

public interface IRoleDAO extends JpaRepository<Role,String>
{
    @Transactional
    @Modifying
    @Query("UPDATE Role r SET r.name=?1,r.user=?2 WHERE r.userid=?3")
    void updateByUser(String name, User user,String userid);
}
