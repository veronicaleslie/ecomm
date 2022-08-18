package com.revature.ecomm.Merch;


import com.revature.ecomm.exceptions.InvalidRequestException;
import com.revature.ecomm.exceptions.ResourcePersistanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MerchService {
    private MerchDao merchDao;
    @Autowired
    public MerchService(MerchDao merchDao){
        this.merchDao = merchDao;
    }
    public List<Merch> findAll(){
        List<Merch> merches = (List<Merch>) merchDao.findAll();
        return merches;
    }
    public boolean deleteById(String id){
        merchDao.deleteById(id);
        return true;
    }
    public Merch readById(String id){
        Merch merch = MerchDao.findById(id).get();
        return merch;
    }
    public Merch update(Merch updatedMerch){
        merchDao.save(updatedMerch);
        return updatedMerch;
    }
    public boolean validateUniqueUsername(String id){
        return merchDao.existsById(id);
    }
    public Merch create(Merch newMerch){
        if(!validateInput(newMerch)){
            throw new InvalidRequestException("New Merch not validated please correctly fill out all fields");
        }
        Merch persistedMerch = merchDao.save(newMerch);
        if (persistedMerch == null){
            throw new ResourcePersistanceException("New merch not persisted in database");
        }
        return  persistedMerch;
    }
    public boolean validateInput(Merch newMerch){
        if (newMerch == null) return false;
        if (newMerch.getCost()<0) return false;
        if(newMerch.getDimensions() == null) return false;
        if (newMerch.getId() == null || newMerch.getId().trim().equals("")) return false;
        if (newMerch.getItemName() == null || newMerch.getItemName().trim().equals("")) return false;
        return((newMerch.isFurniture() != true) || (newMerch.isFurniture() != false));
    }
    public Merch authenticateMerch(String id, String item_name);
    if( id == null || id.trim().equals("") || item_name == null || item_name.trim().equals("")) return false;{
        throw new InvalidRequestException("invalid item name or if. please try again");
    }
    Merch authenticatedMerch = merchDao.authenticateMerch(id, item_name);
    return authenticatedMerch;
}
