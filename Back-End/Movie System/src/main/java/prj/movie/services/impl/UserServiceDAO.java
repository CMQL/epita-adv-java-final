package prj.movie.services.impl;

import prj.movie.Exceptions.AlreadyExistingException;
import prj.movie.data.Contact;
import prj.movie.data.User;
import prj.movie.services.IGenericDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prj.movie.repositories.IUserDAO;

import java.util.List;

@Service
public class UserServiceDAO implements IGenericDAO<User> {
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceDAO.class);

    @Autowired
    IUserDAO userDAO;

    @Autowired
    ContactServiceDAO contactServiceDAO;

    @Override
    public boolean hasDuplicate(User user) {
        return userDAO.findById(user.getUserid()).isPresent();
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }

    @Override
    public void add(User user) throws AlreadyExistingException {
        if(!hasDuplicate(user)) {
            if (!contactServiceDAO.hasDuplicate(user.getContact())) {
                logger.info("Contact not found, creating Contact");
                contactServiceDAO.add(user.getContact());
            } else {
                logger.info("Contact Already exists, linking to contact");
                user.setContact(contactServiceDAO.searchById(user.getUserid()));
            }
            userDAO.save(user);
            logger.info("User created");
        }
        else
        {
            throw new AlreadyExistingException("Movie already exists");
        }
    }

    @Override
    public void update(User user)
    {
        if(hasDuplicate(user))
        {
            userDAO.updateById(user.getUsername(),user.getSeenMovie(),user.getContact(),user.getUserid());
        }
        else
        {
            logger.info("No such movie");
        }
    }
    public User searchById(String id) {
        return userDAO.getById(id);
    }
    public List<User> searchByName(String name) {
        return userDAO.searchByName(name);
    }

    public void delete(String id) {
        userDAO.deleteById(id);
    }
}
