package hiber.dao;


import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   public User userModelCar(String model, int series) {
      String HQL = "FROM User user" +
              " LEFT OUTER JOIN FETCH user.car test" +
              " WHERE test.model = :paramModel" +
              " AND test.series = :paramSeries";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(HQL);
      query.setParameter("paramModel", model);
      query.setParameter("paramSeries", series);
      return query.getSingleResult();
   }

}
