package com.revature.ecomm.Merch;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchDao extends CrudRepository<Merch, String> {
    @Query(value = "FROM Merch WHERE id = :id AND item_name = item_name")
    Merch authenticateMerch(String id, String item_name);


}
