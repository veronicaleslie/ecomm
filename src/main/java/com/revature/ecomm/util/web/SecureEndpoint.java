package com.revature.ecomm.util.web;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecureEndpoint {
    String[] allowedUser() default {};
    boolean isLoggedIn() default false;
}
