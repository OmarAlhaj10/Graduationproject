package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "routine")
public class Routine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_routine")
    private Long idRoutine;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    @OneToMany
    @JoinColumn(name = "id_routine", insertable = false, updatable = false)
    private List<ExerciseRoutine> exercise;

    public Routine() {
    }

    public Routine(String nombre, User user) {
        this.name = nombre;
        this.user = user;
    }

}
