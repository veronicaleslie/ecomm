package com.revature.ecomm.user;

import com.revature.ecomm.exceptions.AuthenticationException;
import com.revature.ecomm.exceptions.InvalidRequestException;
import com.revature.ecomm.exceptions.ResourcePersistanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }
    public List<User> findAll(){
        List<User> users = (List<User>) userDao.findAll();
                return users;
    }
    public User readById(String id){
        User user =userDao.findById(id).get();
        return user;
    }
    public User update(User updatedUser){
        userDao.save(updatedUser);
        return updatedUser;
    }
    public boolean delete(String username){
        userDao.deleteById(username);
        return true;
    }
    public boolean validateUniqueUsername(String username){
        return userDao.existsById(username);
    }
    public User create(User newUser){
        if(!validateInput(newUser)){
            throw new InvalidRequestException("Invalid input. Please fill out all fields.");
        }
        if(validateUniqueUsername(newUser.getUsername())){
            throw new InvalidRequestException("This username is taken. Please enter an new username or login with existing credentials");
        }
        User persistedUser = userDao.save(newUser);
        if(persistedUser == null){
            throw new ResourcePersistanceException("User data not persisted in database.");
        }
        return persistedUser;
    }

    public boolean validateInput(User newUser) {
        if (newUser == null) return false;
        if(newUser.getUsername() == null || newUser.getUsername().trim().equals("")) return false;
        if(newUser.getEmail() == null || newUser.getEmail().trim().equals("")) return false;
        if(newUser.getPassword() == null || newUser.getPassword().trim().equals("")) return false;
        if(newUser.getFirst_name() == null || newUser.getFirst_name().trim().equals("")) return false;
        if(newUser.getLast_name()== null || newUser.getLast_name().trim().equals("")) return false;
        return newUser.getDob() !=null || newUser.getDob().trim().equals("");
    }
    public User authenticateUser(String username, String password){
        if(password== null || password.trim().equals("") ||  username ==null || username.trim().equals("") ){
            throw new InvalidRequestException("Invalid username and/or password. Please try again.");
        }

        User authenticatedUser =userDao.authenticateUser(username,password);
        if(authenticatedUser == null){
            throw new AuthenticationException("User not authenticated. input does not match the database");
        }
        return authenticatedUser;

    }
}
