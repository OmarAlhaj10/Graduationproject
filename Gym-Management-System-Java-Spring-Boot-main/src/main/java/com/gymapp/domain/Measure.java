package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "measure")
public class Measure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_measure")
    private Long idMeasure;

    private Double weight;
    private Double fat;
    private Double neck;
    private Double shoulders;
    private Double leftBicep;
    private Double rightBicep;
    private Double waist;
    private Double hip;
    private Double leftThigh;
    private Double rightThigh;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    public Measure() {
        this.weight = 0.0;
        this.fat = 0.0;
        this.neck = 0.0;
        this.shoulders = 0.0;
        this.leftBicep = 0.0;
        this.rightBicep = 0.0;
        this.waist = 0.0;
        this.hip = 0.0;
        this.leftThigh = 0.0;
        this.rightThigh = 0.0;
    }

    public Measure(Double weight, Double fat, Double neck, Double shoulders, Double leftBicep, Double rightBicep, Double waist, Double hip, Double leftThigh, Double rightThigh, User user) {
        this.weight = weight;
        this.fat = fat;
        this.neck = neck;
        this.shoulders = shoulders;
        this.leftBicep = leftBicep;
        this.rightBicep = rightBicep;
        this.waist = waist;
        this.hip = hip;
        this.leftThigh = leftThigh;
        this.rightThigh = rightThigh;
        this.user = user;
    }

}
