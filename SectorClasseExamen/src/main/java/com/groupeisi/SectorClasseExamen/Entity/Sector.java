package com.groupeisi.SectorClasseExamen.Entity;

import java.util.List;
import jakarta.persistence.*;


@Entity
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
    private List<ClasseExam> classes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClasseExam> getClasses() {
        return classes;
    }

    public void setClasses(List<ClasseExam> classes) {
        this.classes = classes;
    }
}
