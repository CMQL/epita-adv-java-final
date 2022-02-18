package prj.movie.services.impl;

import prj.movie.Exceptions.AlreadyExistingException;
import prj.movie.data.Role;
import prj.movie.repositories.IRoleDAO;
import prj.movie.services.IGenericDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceDAO implements IGenericDAO<Role>
{
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceDAO.class);

    @Autowired
    IRoleDAO roleDAO;

    @Override
    public boolean hasDuplicate(Role role) {
        return roleDAO.findById(role.getUserid()).isPresent();
    }

    @Override
    public List<Role> getAll() {
        return roleDAO.findAll();
    }

    @Override
    public void add(Role role) throws AlreadyExistingException {
        if(!hasDuplicate(role))
        {
            roleDAO.save(role);
            logger.info("Role created");
        }
        else
        {
            throw new AlreadyExistingException("Role already exists");
        }
    }

    @Override
    public void update(Role role)
    {
        if(hasDuplicate(role))
        {
            roleDAO.updateByUser(role.getName(),role.getUser(),role.getUserid());
        }
        else
        {
            logger.info("No such Role");
        }
    }
    public Role search(String username)
    {
        return roleDAO.getById(username);
    }
    public void delete(String username)
    {
        roleDAO.deleteById(username);
    }

}
