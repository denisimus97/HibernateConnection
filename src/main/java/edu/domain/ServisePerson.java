package edu.domain;

import java.sql.SQLException;
import java.util.List;

public class ServisePerson {
    public ServisePerson() {
    }


    private PersonDaoImp personDao = new PersonDaoImp();


    public void insertPerson(Person person) throws SQLException {
        personDao.insert(person);
    }

    public void deletePerson(Person person) {
        personDao.delete(person);
    }

    public void updatePerson(Person person) throws SQLException {
        personDao.update(person);
    }

    public List<Person> findAllUsers() throws SQLException {
        return personDao.getAllUsers();
    }


}