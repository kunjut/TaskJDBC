package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        String query = "CREATE TABLE IF NOT EXISTS User (id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                "name CHAR(30) NOT NULL, lastName CHAR(30), age TINYINT(3));";
        session.createSQLQuery(query).executeUpdate();

        tx.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        String query = "DROP TABLE IF EXISTS User";
        session.createSQLQuery(query).executeUpdate();

        tx.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new User(name, lastName, age));

        tx.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.delete(session.get(User.class, id));

        tx.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        List<User> list = session.createQuery("From User").list();

        tx.commit();
        session.close();
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.createQuery("delete from User").executeUpdate();

        tx.commit();
        session.close();
    }
}
