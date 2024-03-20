package web.userService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
    public void addUser(User user) {
        entityManager.persist(user);
    }
    public void updateUser(User user) {
        entityManager.merge(user);
    }
    public void deleteUserById(Long id) {
        User user = entityManager.find(User.class,id);
        if(user != null) {
            entityManager.remove(user);
        }
        System.out.println("User has been removed");
    }
}
