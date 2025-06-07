package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "exercise")
public class Exercise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id_exercise")
    private Long idExercise;

    private String name;

    public Exercise() {
    }

    public Exercise(String name) {
        this.name = name;
    }

}
