package com.revature.ecomm.profile;

import com.revature.ecomm.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @Column(name = "profile_name")
    private String profileName;
    @OneToOne(optional = false)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User username;
    private double balance;

}
