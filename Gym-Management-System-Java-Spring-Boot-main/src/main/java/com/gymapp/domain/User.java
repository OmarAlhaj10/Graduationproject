package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String gender;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<Role> roles;

    @OneToMany
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private List<Routine> routine;

    public User() {
    }

    public User(String username, String password, String name, String lastname, String email, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
    }

}
