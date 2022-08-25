package com.revature.ecomm.util.web.servlets;


import com.revature.ecomm.user.User;
import com.revature.ecomm.user.UserService;
import com.revature.ecomm.util.web.dto.LoginCreds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthServlet {
    private final UserService userService;
    @Autowired
    public AuthServlet(UserService userService){
        this.userService = userService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void authorizeUser(@RequestBody LoginCreds loginCreds, HttpSession httpSession){
        User authUser = userService.authenticateUser(loginCreds.getUsername(), loginCreds.getPassword());
        httpSession.getAttribute("authUser");
    }
    @DeleteMapping
    public void logout(HttpSession session){
        session.invalidate();
    }
}
