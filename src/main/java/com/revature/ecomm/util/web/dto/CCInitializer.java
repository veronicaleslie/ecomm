package com.revature.ecomm.util.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CCInitializer {
    private String CCNumber;
    private String CcName;
    private int cvv;
    private String expDate;
    private double balance;
    private String username;

    public String getCcNumber() {
        return null;
    }
}
