package com.revature.ecomm.creditCard;


import com.revature.ecomm.user.User;
import com.revature.ecomm.user.UserService;
import com.revature.ecomm.util.web.dto.CCInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class CreditCardServlet {
    private final CreditCardService creditCardService;
    private final CreditCardService userService;
    public  CreditCardServlet(CreditCardService creditCardService, CreditCardService userService){
        this.creditCardService =creditCardService;
        this.userService = userService;
    }
    @CrossOrigin(value = "https://localhost3000", allowCredentials ="true")
    @PostMapping("/newCreditCard")
    public ResponseEntity<CreditCard> CreateCreditCard(@RequestBody CCInitializer newCreditCard.HttpSession req){
      CreditCard newCC = new CreditCard();
        User authUser = (User) req.getAttribute("authUser");


        newCC.setBalance(newCreditCard.getBalance());
        newCC.getCcNumber(newCreditCard.getCCNumber());
        newCC.setCcName(newCreditCard.getCcName());
        newCC.setCvv(newCreditCard.getCvv());
        newCC.setExpDate(newCreditCard.getExpDate());
        newCC.setUsername(userService.readByID(newCreditCard.getUsername()));

        CreditCard creditCard = creditCardService.create(newCC);
        return new ResponseEntity<>(creditCard, HttpStatus.CREATED);

    }
    @GetMapping("/findCreditCard")
    public ResponseEntity<CreditCard> FindCreditCard(@RequestParam String findCreditCard){
        ResponseEntity<CreditCard> creditcard = null;
        try{
            CreditCard creditCard = creditCardService.findbyId(findCreditCard);
            return new ResponseEntity<>(creditCard, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
    }
    @PutMapping("/updateBalance")
    public  ResponseEntity<CreditCard> updateItem(@RequestBody CreditCard creditCard){
        CreditCard updateCreditCard = creditCardService.update(creditCard);
        return ResponseEntity<>(updateCreditCard, HttpStatus.OK);
    }
    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    @DeleteMapping("/delete")
    public void deleteCreditCard(@RequestParam String CcNumber){
        boolean newCreditCard = creditCardService.deleteCcNumber);
    }
}
