package prj.movie.services.impl;

import prj.movie.Exceptions.AlreadyExistingException;
import prj.movie.services.IGenericDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prj.movie.data.Contact;
import prj.movie.repositories.IContactDAO;

import java.util.List;

@Service
public class ContactServiceDAO implements IGenericDAO<Contact>
{
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceDAO.class);
    @Autowired
    IContactDAO contactDAO;

    @Override
    public boolean hasDuplicate(Contact contact) {
        return contactDAO.findById(contact.getName()).isPresent();
    }

    @Override
    public List<Contact> getAll() {
        return contactDAO.findAll();
    }

    @Override
    public void add(Contact contact) throws AlreadyExistingException {
        if(!hasDuplicate(contact))
        {
            contactDAO.save(contact);
            logger.info("Contact created");
        }
        else
        {
            throw new AlreadyExistingException("Contact already exists");
        }
    }

    @Override
    public void update(Contact contact)
    {
        if(hasDuplicate(contact))
        {
            contactDAO.updateByName(contact.getName(),contact.getBirthday(),contact.getEmail(),contact.getGender(),contact.getUserid());
        }
        else
        {
            logger.info("No such movie");
        }
    }
    public Contact searchById(String id) {
        return contactDAO.getById(id);
    }
    /*public List<Contact> searchByName(String name) {
        return movieDAO.searchByName(name);
    }*/


    public void delete(String id) {
        contactDAO.deleteById(id);
    }

}
