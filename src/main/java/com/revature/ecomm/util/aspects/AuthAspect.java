package com.revature.ecomm.util.aspects;

import com.revature.ecomm.exceptions.AuthenticationException;
import com.revature.ecomm.util.web.SecureEndpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class AuthAspect {
    private HttpServletRequest request;
    @Autowired
    public AuthAspect(HttpServletRequest request){
        this.request = request;
    }
    @Around("@annotation(com.revature.ecomm.util.web.SecureEndpoint)")
    public Object secureEndpoints(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Method method = ((MethodSignature) proceedingJoinPoint.getSignature().getMethod());
        SecureEndpoint anno = method.getAnnotation(SecureEndpoint.class);
        List<String> allowedUsers = Arrays.asList(anno.allowedUser());

        if (request.getParameter("username") == null) throw new AuthenticationException("Log in required");

        String username = request.getParameter("username");
        if (anno.isLoggedIn() == true && username == null) throw new AuthenticationException("Login required to use this function");
        if (!allowedUsers.isEmpty() && !allowedUsers.contains(username)) throw new AuthenticationException("Request cannot be made by" + username);
        Object returned = proceedingJoinPoint.proceed();
        return returned;
    }
}
