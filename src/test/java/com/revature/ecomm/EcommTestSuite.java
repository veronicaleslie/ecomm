package com.revature.ecomm;

import com.revature.ecomm.Merch.Merch;
import com.revature.ecomm.Merch.MerchDao;
import com.revature.ecomm.Merch.MerchService;
import com.revature.ecomm.creditCard.CreditCard;
import com.revature.ecomm.creditCard.CreditCardDao;
import com.revature.ecomm.creditCard.CreditCardService;
import com.revature.ecomm.order.OrderDao;
import com.revature.ecomm.order.OrderService;
import com.revature.ecomm.user.User;
import com.revature.ecomm.user.UserDao;
import com.revature.ecomm.user.UserService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EcommTestSuite {
    User ex;
    Merch ex1;
    CreditCardService in;
    UserService in1;
    MerchService in2;
    OrderService ex2;



    MerchDao mockMerchDao;
    CreditCardDao mockCreditCardDao;
    UserDao mockUserDao;
    OrderDao mockOrderDao;


    @BeforeEach
    public void testPrep(){
        mockCreditCardDao = mock(CreditCardDao.class);
        mockMerchDao = mock(MerchDao.class);
        mockOrderDao = mock(OrderDao.class);
        mockUserDao = mock(UserDao.class);
        ex = new User("tester", "password", "bob", "burger", "bob@mail.com", "01-01-2001", false);
        ex1 = new Merch("1","bookshelf", 15, 18, "2 X 3 X 6", false);
        ex2 = new OrderService(mockOrderDao);
        in = new CreditCardService(mockCreditCardDao);
        in1 = new UserService(mockUserDao);
        in2 = new MerchService(mockMerchDao);



        @Test
                public void testing_validInput_CC_returnTrue(){
            CreditCard creditCard = new CreditCard(123456, 123, "Bob", "8-24", 100, ex);
            boolean result = ex.validateInput(user);
            Assertions.assertTrue(result);
        }
        @Test
                public  void Test_validInput_createUser_returnUser(){
            User user = new User("Lin", "passw", "Linda", "Burn", "lin@email.com", "02-02-2001", false);
            when(mockUserDao.save(user)).thenReturn(user);
            User realUser = in1.create(user);
        }


    }


}
