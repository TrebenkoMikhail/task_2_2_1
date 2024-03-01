package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void addUser(User user) {
      try {
         sessionFactory.getCurrentSession().save(user);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> listUsers() {
       TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
       try {
           return query.getResultList();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return query.getResultList();
   }

   @Override
   public void saveUserWithCar(User user, Car car) {
      try {
         user.setCar(car);
         sessionFactory.getCurrentSession().save(user);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @Override
   @Transactional(readOnly = true)
   public User getUserByCarModelAndSeries(String model, int series) {
         CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
         CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
         Root<User> root = criteriaQuery.from(User.class);
         criteriaQuery.select(root)
                 .where(criteriaBuilder.equal(root.get("car").get("model"), model),
                         criteriaBuilder.equal(root.get("car").get("series"), series));
         return sessionFactory.getCurrentSession().createQuery(criteriaQuery).uniqueResult();
   }

   @Override
   @Transactional
   public void addCar(Car car) {
      try {
         sessionFactory.getCurrentSession().save(car);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }


}
