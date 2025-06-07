package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "exercise_routine")
public class ExerciseRoutine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exercise_routine")
    private Long idExerciseRoutine;

    @OneToOne
    @JoinColumn(name = "id_exercise")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "id_routine")
    private Routine routine;

    private int series;
    private int repetitions;
    private Double previousWeight;
    private Double currentWeight;

    public ExerciseRoutine() {
    }

    public ExerciseRoutine(int series, int repetitions, Double previousWeight, Double currentWeight) {
        this.series = series;
        this.repetitions = repetitions;
        this.previousWeight = previousWeight;
        this.currentWeight = currentWeight;
    }

}
