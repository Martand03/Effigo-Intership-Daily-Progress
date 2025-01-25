package com.inEffigo.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userId = 0;
    static {
        users.add(new User(++userId, "Apple", LocalDate.now().minusYears(20)));
        users.add(new User(++userId, "Orange", LocalDate.now().minusYears(10)));
        users.add(new User(++userId, "Banana", LocalDate.now().minusYears(5)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User saveUser(User user){
        user.setId(++userId);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

}
