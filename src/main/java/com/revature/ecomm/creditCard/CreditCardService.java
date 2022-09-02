package com.revature.ecomm.creditCard;

import com.revature.ecomm.exceptions.InvalidRequestException;
import com.revature.ecomm.exceptions.ResourcePersistanceException;
import com.revature.ecomm.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CreditCardService {
    public boolean deleteCcNumber;
    private CreditCardDao creditCardDao;
    @Autowired
    public CreditCardService(CreditCardDao creditCardDao){
        this.creditCardDao = creditCardDao;
    }
    public CreditCard findbyId(String id){
        CreditCard creditCard = creditCardDao.findById(id).get();
        return creditCard;
    }
    public boolean delete(String ccNumber){
        creditCardDao.deleteById(ccNumber);
        return true;
    }
    public CreditCard create(CreditCard newCreditCard) {
        if (!validateInput(newCreditCard)) {
            throw new InvalidRequestException("Invalid input. Please fill all fields");
        }
        CreditCard persistedCreditCard = creditCardDao.save(newCreditCard);
        if(persistedCreditCard == null){
            throw new ResourcePersistanceException("Credit Card could not be persisted ");
        }
        return persistedCreditCard;
    }
    public CreditCard update(CreditCard updateCreditCard){
        creditCardDao.save(updateCreditCard);
        return updateCreditCard;
    }
   public boolean validateInput(CreditCard newCreditCard){
        if (newCreditCard == null) return false;
        if (newCreditCard.getBalance() < 0) return false;
        if (newCreditCard.getCvv() <= 0 || newCreditCard.getCvv() == 0) return false;
       if (newCreditCard.getCcNumber() == null || newCreditCard.getCcNumber().trim().equals("")) return false;
       if (newCreditCard.getExpDate() == null || newCreditCard.getExpDate().trim().equals("")) return false;

       if (newCreditCard.getCcName() == null || newCreditCard.getCcName().trim().equals("")) return false;
        return (newCreditCard.getUsername() != null || !newCreditCard.getUsername().equals(""));
   }

    public User readByID(String username) {
        return null;
    }
}
