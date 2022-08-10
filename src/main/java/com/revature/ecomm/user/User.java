package com.revature.ecomm.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column(name = "first_name", length = 25, nullable = false)
    private String first_name;
    @Column(name = "last_name", length = 25, nullable = false)
    private String last_name;
    @Column(name = "email", nullable = false)
    private String email;
    private String dob;
    private boolean admin;
}
