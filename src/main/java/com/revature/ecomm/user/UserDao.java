package com.revature.ecomm.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
    @Query(value = "FROM User WHERE username= :username AND password= :password")
    User authencateUser(String username, String password);
}
