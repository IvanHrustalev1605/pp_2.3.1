package web.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import web.util.HibernateUtil;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public void add(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.persist(user);
                transaction.commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            var thisUser = session.get(User.class, id);
            session.remove(thisUser);
            transaction.commit();
        }
    }

    @Override
    public User getUserById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
           User user = session.get(User.class, id);
            transaction.commit();
            return user;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            String sql = "From " + User.class.getSimpleName();
            userList = session.createQuery(sql, User.class).getResultList();
            return userList;
        }
    }
}
