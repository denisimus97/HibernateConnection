package edu.domain;

import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {
    void insert(Person person) throws SQLException;
    List<Person> getAllUsers() throws SQLException;
    void update(Person person) throws SQLException;
    void delete(Person person);
}
