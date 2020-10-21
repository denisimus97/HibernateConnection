package edu.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;
import java.sql.SQLException;
import java.util.List;

public class PersonDaoImp implements PersonDAO{
    @Override
    public void insert(Person person) throws SQLException {
        SessionFactory sf = buildSessionFactory();
        Session session = sf.openSession();
        session.getTransaction().begin();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Person> getAllUsers() throws SQLException {
        List<Person> person =(List<Person>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Person", Person.class).list();
return person;
    }

    @Override
    public void update(Person person) throws SQLException {
        SessionFactory sf = buildSessionFactory();
        Session session = sf.openSession();
        session.getTransaction().begin();
        session.update(person);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void delete(Person person) {
        SessionFactory sf = buildSessionFactory();
        Session session = sf.openSession();
        session.getTransaction().begin();
        session.delete(person);
        session.getTransaction().commit();
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {
            System.err.println("Initial session factory failed " + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
}
