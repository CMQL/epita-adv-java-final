package prj.movie.services.impl;

import prj.movie.Exceptions.AlreadyExistingException;
import prj.movie.repositories.IAddressDAO;
import prj.movie.services.IGenericDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prj.movie.data.Address;

import java.util.List;

@Service
public class AddressServiceDAO implements IGenericDAO<Address>
{
    private static final Logger logger = LoggerFactory.getLogger(MovieServiceDAO.class);
    @Autowired
    IAddressDAO addressDAO;

    @Override
    public boolean hasDuplicate(Address address) {
        return addressDAO.findById(address.getName()).isPresent();
    }

    @Override
    public List<Address> getAll() {
        return addressDAO.findAll();
    }

    @Override
    public void add(Address address) throws AlreadyExistingException {
        if(!hasDuplicate(address))
        {
            addressDAO.save(address);
            logger.info("Address created");
        }
        else
        {
            throw new AlreadyExistingException("Address already exists");
        }
    }

    @Override
    public void update(Address address)
    {
        if(hasDuplicate(address))
        {
            addressDAO.updateByName(address.getName(),address.getCountry(),address.getArea(),address.getCity(),address.getStreet(),address.getNumber(),address.getContact(),address.getUserid());
        }
        else
        {
            logger.info("No such address");
        }
    }

    public Address search(String name)
    {
        return addressDAO.getById(name);
    }

    public void delete(String name)
    {
        addressDAO.deleteById(name);
    }
}
