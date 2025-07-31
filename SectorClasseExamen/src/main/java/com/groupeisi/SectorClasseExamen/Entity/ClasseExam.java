package com.groupeisi.SectorClasseExamen.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class ClasseExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;
    private String description;

    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
