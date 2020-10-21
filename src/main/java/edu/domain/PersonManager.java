package edu.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class PersonManager {
    public static void main(String[] args) throws SQLException {
        PersonDAO person = new PersonDaoImp();
        ServisePerson userServ = new ServisePerson();
        Person vas1 =  new Person("vasili1","sery-@ya.ru","qsdfke");
        Person vas12 =  new Person("vasili11","sery-@1ya.ru","q1sdfke");
        userServ.insertPerson(vas1);
       // userServ.insertPerson(vas12);
       // userServ.deletePerson(vas1);
        System.out.println(userServ.findAllUsers());

       // person.getAllUsers();


    }
}
