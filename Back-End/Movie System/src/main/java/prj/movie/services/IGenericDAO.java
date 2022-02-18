package prj.movie.services;

import prj.movie.Exceptions.AlreadyExistingException;

import java.util.List;

public interface IGenericDAO<T>
{
    boolean hasDuplicate(T obj);
    List<T> getAll();
    void add(T obj) throws AlreadyExistingException;
    //searchbyname string
    void update(T obj);
    //deletebyid string
}
