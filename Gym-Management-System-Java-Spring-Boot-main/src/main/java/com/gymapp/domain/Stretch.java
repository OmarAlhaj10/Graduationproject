package com.gymapp.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "stretch")
public class Stretch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stretch")
    private Long idStretch;
    private String name;
    private String description;
    private String url;

    public Stretch() {
    }

    public Stretch(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

}
