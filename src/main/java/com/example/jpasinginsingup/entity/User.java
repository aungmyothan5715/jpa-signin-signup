package com.example.jpasinginsingup.entity;

import com.example.jpasinginsingup.validate.NamedNotAdmin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NamedNotAdmin(message = "Name can not be admin!")
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    public void addRole(Role role){
        role.getUsers().add(this);
        this.roles.add(role);
    }


}
